package com.alexkarav.testandroidvacc24.domain.mappers

import com.alexkarav.testandroidvacc24.data.remote.models.user.UserLoginInfoRequest
import com.alexkarav.testandroidvacc24.domain.models.UserLoginInfo

object LoginInfoIntoRequestMapper {

    fun intoRequest(loginInfo: UserLoginInfo): UserLoginInfoRequest {
        return UserLoginInfoRequest(password = loginInfo.userPassword, username = loginInfo.userLogin)
    }

}