package com.example.kitchenapp.presentation.homeScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kitchenapp.presentation.homeScreen.constants.NavigationConstants.SideNavItems
import com.example.kitchenapp.ui.theme.BrownishBlack
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun SideNavbar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationRail(
        modifier = Modifier
            .fillMaxHeight(),
        containerColor = MatteBlack,
        header = {
            Text(
                text = "Menu",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PerfectGray
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {
            SideNavItems.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = {
                        Row(
                            modifier = Modifier
                                .background(
                                    color = if (selectedItem == index) BrownishBlack else Color.Transparent,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                modifier = Modifier.size(28.dp),
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = item.title,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route)
                    },
                    colors = NavigationRailItemDefaults.colors(
                        unselectedIconColor = PerfectGray,
                        unselectedTextColor = PerfectGray,

                        selectedIconColor = HotOrange,
                        selectedTextColor = HotOrange,

                        indicatorColor = Color.Transparent
                    ),
                )
            }
        }
    }
}
