package com.example.kitchenapp.presentation.homeScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.kitchenapp.presentation.homeScreen.component.SideNavbar
import com.example.kitchenapp.presentation.navigation.Navigation
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.PerfectGray
import com.example.kitchenapp.ui.theme.ShockingBlack
import com.example.kitchenapp.ui.theme.TrueBlack
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
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
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(color = ShockingBlack),
                    contentAlignment = Alignment.Center
                ) {
                    val currentDateTime = java.time.LocalDateTime.now()
                    Text(
                        text = currentDateTime.format(
                            DateTimeFormatter.ofPattern(
                                "yyyy-MM-dd EEEE",
                                Locale.forLanguageTag("en")
                            )
                        ),
                        color = PerfectGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(color = CarbonFiber)
                )

                Navigation(
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
