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
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.kitchenapp.presentation.staffScreen.components.StaffCard
import com.example.kitchenapp.presentation.staffScreen.components.StaffHeader
import com.example.kitchenapp.presentation.staffScreen.constants.getStaffStatus
import com.example.kitchenapp.presentation.staffScreen.uiState.StaffCardUIState
import com.example.kitchenapp.presentation.staffScreen.viewModel.StaffViewModel
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.RedAura

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
                val staffStatus = getStaffStatus(item.status)

                val currentStatus = item.status.lowercase(LocalLocale.current.platformLocale)
                StaffCard(
                    state = StaffCardUIState(
                        imageUrl = item.imageUrl,
                        statusColor = staffStatus.statusColor,
                        secondaryColor = staffStatus.secondaryColor,
                        staffName = item.name,
                        statusText = staffStatus.statusText,
                        department = item.department,
                        role = item.role,
                        workedTime = item.workedHoursToday.toString(),
                        startColor = Malachite,
                        breakColor = HotOrange,
                        endColor = RedAura,
                        isStartEnabled = currentStatus == "off_duty" || currentStatus == "on_break",
                        isBreakEnabled = currentStatus == "working",
                        isEndEnabled = currentStatus == "working" || currentStatus == "on_break"

                    ),
                    onStartClick = { viewModel.onStartClicked(staffId = item.id) },
                    onBreakClick = { viewModel.onBreakClicked(staffId = item.id) },
                    onEndClick = { viewModel.onEndClicked(staffId = item.id) }
                )
            }
        }
    }
}
