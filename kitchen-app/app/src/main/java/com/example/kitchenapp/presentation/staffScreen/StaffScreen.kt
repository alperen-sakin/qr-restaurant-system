package com.example.kitchenapp.presentation.staffScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.kitchenapp.presentation.staffScreen.components.StaffCard
import com.example.kitchenapp.presentation.staffScreen.components.StaffHeader
import com.example.kitchenapp.presentation.staffScreen.constants.getStaffStatus
import com.example.kitchenapp.presentation.staffScreen.uiState.StaffCardUIState
import com.example.kitchenapp.presentation.staffScreen.viewModel.StaffViewModel

private const val GRID_SPAN_COUNT = 3

@Composable
fun StaffScreen(
    modifier: Modifier = Modifier,
    viewModel: StaffViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        StaffHeader()

        LazyVerticalGrid(
            columns = GridCells.Fixed(GRID_SPAN_COUNT),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            items(state.staffs) { item ->
                val status = getStaffStatus(item.status)
                StaffCard(
                    state = StaffCardUIState(
                        imageUrl = item.imageUrl,
                        statusColor = status.statusColor,
                        secondaryColor = status.secondaryColor,
                        staffName = item.name,
                        statusText = status.statusText,
                        department = item.department,
                        role = item.role,
                        workedTime = item.workedHoursToday.toString()

                    )
                )
            }
        }
    }
}
