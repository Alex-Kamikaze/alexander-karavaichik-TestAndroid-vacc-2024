package com.alexkarav.testandroidvacc24.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int,
    val userEmail: String,
    val userName: String,
    val userPassword: String,
    val userFirstName: String,
    val userLastName: String
)
