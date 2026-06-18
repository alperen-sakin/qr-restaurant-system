package com.example.kitchenapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kitchenapp.data.dto.OrderDto
import com.example.kitchenapp.data.mapper.toDomain
import com.example.kitchenapp.domain.model.Order
import com.example.kitchenapp.domain.repository.OrderRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : OrderRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getOrders(): Flow<List<Order>> = callbackFlow {
        val subscription = firestore.collection("orders")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val orders = snapshots.documents.mapNotNull { doc ->
                        doc.toObject(OrderDto::class.java)?.toDomain()
                    }
                    trySend(orders)
                }
            }
        awaitClose { subscription.remove() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getCompletedOrders(): Flow<List<Order>> = callbackFlow {
        val subscription = firestore.collection("orders")
            .whereEqualTo("status", "served")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener

                }

                if (snapshots != null) {
                    val orders = snapshots.documents.mapNotNull { doc ->
                        doc.toObject(OrderDto::class.java)?.toDomain()
                    }
                    trySend(orders)
                }
            }

        awaitClose { subscription.remove() }

    }

    override suspend fun updateOrderStatus(orderId: String, newStatus: String) {
        firestore.collection("orders")
            .document(orderId)
            .update("status", newStatus)
            .await()
    }
}
