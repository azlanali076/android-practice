package com.example.practice.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(customer: Customer)

    @Query("SELECT * FROM customers ORDER BY id ASC")
    fun getAll(): List<Customer>
}