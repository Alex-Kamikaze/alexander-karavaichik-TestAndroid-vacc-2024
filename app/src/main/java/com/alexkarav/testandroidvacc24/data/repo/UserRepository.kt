package com.alexkarav.testandroidvacc24.data.repo

interface UserRepository {

    suspend fun saveNewUser()
}