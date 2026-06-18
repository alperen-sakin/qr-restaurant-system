package com.example.kitchenapp.presentation.historyScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.historyScreen.constants.HistoryDataTitles
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.ExtremeBlack
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

private const val DEFAULT_WEIGHT = 1f
private const val SECONDARY_WEIGHT = 1.5f

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
                .padding(horizontal = 32.dp, vertical = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HistoryDataTitles.forEach { title ->
                Text(
                    text = title,
                    color = PerfectGray,
                    modifier = Modifier
                        .weight(if (title == "Date & Time") SECONDARY_WEIGHT else DEFAULT_WEIGHT),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = CarbonFiber
        )

        HistoryItem()
    }
}
