package com.example.kitchenapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kitchenapp.presentation.homeScreen.HomeScreen
import com.example.kitchenapp.ui.theme.KitchenAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KitchenAppTheme {
                HomeScreen()
            }
        }
    }
}
