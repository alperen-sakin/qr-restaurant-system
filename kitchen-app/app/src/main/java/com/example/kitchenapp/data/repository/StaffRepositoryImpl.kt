package com.example.kitchenapp.data.repository

import com.example.kitchenapp.data.dto.StaffDto
import com.example.kitchenapp.data.mapper.toDomain
import com.example.kitchenapp.domain.model.Staff
import com.example.kitchenapp.domain.repository.StaffRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StaffRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : StaffRepository {
    override fun getStaff(): Flow<List<Staff>> = callbackFlow {
        val subscription = firestore.collection("staff")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val staff = snapshots.documents.mapNotNull { doc ->
                        doc.toObject(StaffDto::class.java)?.toDomain()
                    }
                    trySend(staff)
                }
            }
        awaitClose { subscription.remove() }
    }

    override suspend fun updateStaffStatus(staffId: String, newStatus: String, clockInTime: Long) {
        try {
            val updates = mapOf(
                "status" to newStatus,
                "lastClockInTime" to clockInTime
            )

            firestore.collection("staff")
                .document(staffId)
                .update(updates)
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun updateStaffBreak(staffId: String, newStatus: String, workedHoursToday: Long) {
        try {
            val updates = mapOf(
                "status" to newStatus,
                "workedHoursToday" to workedHoursToday
            )

            firestore.collection("staff")
                .document(staffId)
                .update(updates)
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun updateStaffEnd(staffId: String, newStatus: String, workedHoursToday: Long) {
        try {
            val updates = mapOf(
                "status" to newStatus,
                "workedHoursToday" to workedHoursToday,
                "lastClockInTime" to 0L
            )

            firestore.collection("staff")
                .document(staffId)
                .update(updates)
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
