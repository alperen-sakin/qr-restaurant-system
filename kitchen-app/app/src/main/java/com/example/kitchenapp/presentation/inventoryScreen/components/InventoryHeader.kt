package com.example.kitchenapp.presentation.inventoryScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
fun InventoryHeader(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
    onSearchValueChange: (String) -> Unit,
    searchValue: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TitleSection()

        InputSection(searchValue, onSearchValueChange, onAddClick)
    }
}

@Composable
private fun InputSection(
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    onAddClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchValue,
            onValueChange = onSearchValueChange,
            singleLine = true,
            placeholder = { Text(text = "Search Item..") },
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

        Button(
            onClick = onAddClick,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = HotOrange,
                contentColor = Color.White
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Search",
                )

                Text(
                    text = "Add Item",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun TitleSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Inventory",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Manage your inventory stock status here",
            color = PerfectGray,
            fontSize = 16.sp
        )
    }
}
