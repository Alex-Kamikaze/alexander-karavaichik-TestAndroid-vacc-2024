package com.alexkarav.testandroidvacc24.data.repo

import com.alexkarav.testandroidvacc24.domain.models.UserLoginInfo

interface UserRepository {

    suspend fun saveNewUser()

    suspend fun loginUser(userLoginInfo: UserLoginInfo): Result<Boolean>
}