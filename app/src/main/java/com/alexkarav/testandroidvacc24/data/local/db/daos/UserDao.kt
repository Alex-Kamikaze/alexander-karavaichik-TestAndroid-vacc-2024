package com.alexkarav.testandroidvacc24.data.local.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alexkarav.testandroidvacc24.data.local.db.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertNewUser(user: User)

    @Update
    suspend fun updateUserInfo(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * from user WHERE userId = :id")
    suspend fun getUserById(id: Int): User

}