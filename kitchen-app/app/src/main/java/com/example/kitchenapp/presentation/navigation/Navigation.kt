package com.example.kitchenapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kitchenapp.presentation.historyScreen.HistoryScreen
import com.example.kitchenapp.presentation.inventoryScreen.InventoryScreen
import com.example.kitchenapp.presentation.ordersScreen.OrdersScreen
import com.example.kitchenapp.presentation.staffScreen.StaffScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "orders",
        modifier = modifier
    ) {
        composable("orders") {
            OrdersScreen()
        }
        composable("history") {
            HistoryScreen()
        }
        composable("inventory") {
            InventoryScreen()
        }
        composable("staff") {
            StaffScreen()
        }
    }
}
