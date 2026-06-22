package com.example.kitchenapp.di

import com.example.kitchenapp.data.repository.InventoryRepositoryImpl
import com.example.kitchenapp.data.repository.OrderRepositoryImpl
import com.example.kitchenapp.data.repository.StaffRepositoryImpl
import com.example.kitchenapp.domain.repository.InventoryRepository
import com.example.kitchenapp.domain.repository.OrderRepository
import com.example.kitchenapp.domain.repository.StaffRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository

    @Binds
    @Singleton
    abstract fun bindInventoryRepository(
        inventoryRepositoryImpl: InventoryRepositoryImpl
    ): InventoryRepository

    @Binds
    @Singleton
    abstract fun bindStaffRepository(
        staffRepositoryImpl: StaffRepositoryImpl
    ): StaffRepository
}
