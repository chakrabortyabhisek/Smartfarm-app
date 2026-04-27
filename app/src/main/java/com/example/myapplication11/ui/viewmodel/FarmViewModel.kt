package com.example.myapplication11.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication11.data.model.SoilData
import com.example.myapplication11.data.model.WeatherData
import com.example.myapplication11.data.repository.FarmRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FarmViewModel : ViewModel() {
    private val repository = FarmRepository()

    private val _soilData = MutableStateFlow(SoilData())
    val soilData: StateFlow<SoilData> = _soilData.asStateFlow()

    private val _weatherData = MutableStateFlow(WeatherData(location = "Loading..."))
    val weatherData: StateFlow<WeatherData> = _weatherData.asStateFlow()

    init {
        observeSoilData()
    }

    private fun observeSoilData() {
        viewModelScope.launch {
            repository.getSoilDataFlow().collect {
                _soilData.value = it
            }
        }
    }

    fun updateSoilMoisture(newMoisture: Int) {
        viewModelScope.launch {
            repository.updateSoilData(_soilData.value.copy(moisture = newMoisture))
        }
    }
}
