package com.example.practice.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practice.models.Customer
import com.example.practice.models.CustomerDao

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
        private var DB_INSTANCE: AppDatabase? = null

        fun getInstance (context: Context): AppDatabase {
            return DB_INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context,AppDatabase::class.java,"my_db").allowMainThreadQueries().build()
                DB_INSTANCE = instance
                instance
            }
        }
    }

}