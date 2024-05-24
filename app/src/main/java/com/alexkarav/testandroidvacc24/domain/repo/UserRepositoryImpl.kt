package com.alexkarav.testandroidvacc24.domain.repo

import com.alexkarav.testandroidvacc24.data.local.datastore.DataStoreManager
import com.alexkarav.testandroidvacc24.data.local.db.AppDatabase
import com.alexkarav.testandroidvacc24.data.remote.ShopListApi
import com.alexkarav.testandroidvacc24.data.remote.models.UserLoginInfoRequest
import com.alexkarav.testandroidvacc24.data.remote.models.UserLoginResponse
import com.alexkarav.testandroidvacc24.data.repo.UserRepository
import com.alexkarav.testandroidvacc24.domain.models.UserLoginInfo
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val appDatabase: AppDatabase, private val dataStoreManager: DataStoreManager, private val shopListApi: ShopListApi): UserRepository {
    private val userDao = appDatabase.getUserDao()
    override suspend fun saveNewUser() {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(userLoginInfo: UserLoginInfo): Result<Boolean> {
        try {
            shopListApi.loginUser(
                userLoginInfoRequest = UserLoginInfoRequest(password = userLoginInfo.userPassword, username = userLoginInfo.userLogin)
            )
        }
        catch (ex: Exception) {
            return Result.failure(ex)
        }
        return Result.success(true)
    }


}