package com.example.hw02

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class viewScreen() {
        mainview,
        detail
    }
var current : viewdetail? = null
    @Composable
    fun mainApp(
        navController: NavHostController = rememberNavController(),
        currentState:viewmodel = viewModel()
    ) {
        // Get current back stack entry
        val backStackEntry by navController.currentBackStackEntryAsState()
        // Get the name of the current screen
        val currentScreen = viewScreen.valueOf(
            backStackEntry?.destination?.route ?: viewScreen.mainview.name
        )
        Scaffold(
        ) { innerPadding ->
            val uiState by currentState.uiState.collectAsState()
            NavHost(
                navController = navController,
                startDestination = viewScreen.mainview.name,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(viewScreen.mainview.name) {
                        mainview(onNextButtonClicked = {
                            currentState.Set(it)
                            navController.navigate(viewScreen.detail.name) })
                }
                composable(viewScreen.detail.name) {
                    detailview(uiState.currentview, onBackButtonClicked = {
                        navController.navigate(viewScreen.mainview.name)
                        },
                        onMapButtonClicked = {
                            // Open Google Maps
                            val gmmIntentUri = Uri.parse("geo:0,0?q=${uiState.currentview.title}")
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps")
                            navController.context.startActivity(mapIntent)
                        }
                    )
                }
            }
        }
    }
