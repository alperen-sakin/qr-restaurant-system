package com.example.kitchenapp.presentation.historyScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun HistoryHeader(
    modifier: Modifier = Modifier,
    searchValue: String,
    onSearchValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Order History",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "See all done orders and filter by ID",
                color = PerfectGray,
                fontSize = 14.sp
            )
        }

        OutlinedTextField(
            value = searchValue,
            onValueChange = {
                onSearchValueChange(it)
            },
            singleLine = true,
            placeholder = { Text(text = "Order ID") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = CarbonFiber2,
                unfocusedContainerColor = MatteBlack,
                unfocusedLeadingIconColor = PerfectGray,
                unfocusedPlaceholderColor = PerfectGray,

                focusedBorderColor = HotOrange,
                focusedTextColor = Color.White,
                focusedLeadingIconColor = Color.White,
            ),
            shape = RoundedCornerShape(16.dp),

        )
    }
}
