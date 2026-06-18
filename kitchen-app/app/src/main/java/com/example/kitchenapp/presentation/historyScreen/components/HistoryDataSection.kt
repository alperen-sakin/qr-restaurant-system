package com.example.kitchenapp.presentation.historyScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.historyScreen.constants.HistoryDataTitles
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.ExtremeBlack
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun HistoryDataSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = CarbonFiber2,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = MatteBlack)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .background(color = ExtremeBlack)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HistoryDataTitles.forEach { title ->
                Text(
                    text = title,
                    color = PerfectGray,
                    modifier = Modifier
                        .weight(1f),
                    fontSize = 14.sp
                )
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = CarbonFiber
        )
    }
}
