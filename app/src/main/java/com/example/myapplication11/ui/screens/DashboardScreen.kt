package com.example.myapplication11.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication11.ui.viewmodel.FarmViewModel
import com.example.myapplication11.ui.theme.MyApplication11Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: FarmViewModel) {
    val soilData by viewModel.soilData.collectAsState()
    val weatherData by viewModel.weatherData.collectAsState()

    DashboardContent(
        soilMoisture = soilData.moisture,
        soilPh = soilData.phLevel,
        soilNitrogen = soilData.nitrogen,
        weatherTemp = weatherData.temperature,
        weatherCondition = weatherData.condition,
        weatherLocation = weatherData.location,
        onSimulateUpdate = { viewModel.updateSoilMoisture((0..100).random()) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardContent(
    soilMoisture: Int,
    soilPh: Double,
    soilNitrogen: Int,
    weatherTemp: Double,
    weatherCondition: String,
    weatherLocation: String,
    onSimulateUpdate: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Smart Farm Dashboard") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                WeatherCard(
                    temp = weatherTemp,
                    condition = weatherCondition,
                    location = weatherLocation
                )
            }
            item {
                SoilCard(
                    moisture = soilMoisture,
                    ph = soilPh,
                    nitrogen = soilNitrogen
                )
            }
            item {
                Button(
                    onClick = onSimulateUpdate,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Simulate Soil Update")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    MyApplication11Theme {
        DashboardContent(
            soilMoisture = 45,
            soilPh = 6.5,
            soilNitrogen = 20,
            weatherTemp = 28.5,
            weatherCondition = "Sunny",
            weatherLocation = "Farm Central",
            onSimulateUpdate = {}
        )
    }
}

@Composable
fun WeatherCard(temp: Double, condition: String, location: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Weather Info", style = MaterialTheme.typography.titleLarge)
            Text("Location: $location")
            Text("Temperature: $temp°C")
            Text("Condition: $condition")
        }
    }
}

@Composable
fun SoilCard(moisture: Int, ph: Double, nitrogen: Int) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Soil Info", style = MaterialTheme.typography.titleLarge)
            Text("Moisture: $moisture%")
            Text("pH Level: $ph")
            Text("Nitrogen: $nitrogen mg/kg")
        }
    }
}
