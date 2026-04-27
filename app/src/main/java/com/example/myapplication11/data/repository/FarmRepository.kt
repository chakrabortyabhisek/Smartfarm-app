package com.example.myapplication11.data.repository

import com.example.myapplication11.data.model.SoilData
import com.example.myapplication11.data.model.WeatherData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class FarmRepository {
    private val database = FirebaseDatabase.getInstance().getReference("farm_data")

    fun getSoilDataFlow(): Flow<SoilData> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(SoilData::class.java)
                if (data != null) {
                    trySend(data)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        database.child("soil").addValueEventListener(listener)
        awaitClose { database.child("soil").removeEventListener(listener) }
    }

    suspend fun updateSoilData(soilData: SoilData) {
        database.child("soil").setValue(soilData)
    }
}
