package com.example.myapplication11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication11.ui.screens.DashboardScreen
import com.example.myapplication11.ui.theme.MyApplication11Theme
import com.example.myapplication11.ui.viewmodel.FarmViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication11Theme {
                val viewModel: FarmViewModel = viewModel()
                DashboardScreen(viewModel = viewModel)
            }
        }
    }
}
