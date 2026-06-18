package com.example.kitchenapp.data.repository

import com.example.kitchenapp.data.dto.InventoryItemDto
import com.example.kitchenapp.data.mapper.toDomain
import com.example.kitchenapp.domain.model.InventoryItem
import com.example.kitchenapp.domain.repository.InventoryRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import kotlin.jvm.java

class InventoryRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : InventoryRepository {

    override fun getInventoryItems(): Flow<List<InventoryItem>> = callbackFlow {
        val subscription = firestore.collection("inventory")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val inventoryItems = snapshots.documents.mapNotNull { doc ->
                        doc.toObject(InventoryItemDto::class.java)?.toDomain()
                    }
                    trySend(inventoryItems)
                }
            }

        awaitClose { subscription.remove() }
    }
}
