package com.example.kitchenapp.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kitchenapp.presentation.homeScreen.component.SideNavbar
import com.example.kitchenapp.presentation.navigation.Navigation
import com.example.kitchenapp.ui.theme.TrueBlack

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = TrueBlack)
        ) {
            SideNavbar(navController = navController)

            Navigation(
                navController = navController,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
