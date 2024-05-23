package com.alexkarav.testandroidvacc24.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexkarav.testandroidvacc24.data.local.db.daos.UserDao
import com.alexkarav.testandroidvacc24.data.local.db.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}