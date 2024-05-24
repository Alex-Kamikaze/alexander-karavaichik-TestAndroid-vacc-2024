package com.alexkarav.testandroidvacc24.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexkarav.testandroidvacc24.domain.models.UserLoginInfo
import com.alexkarav.testandroidvacc24.domain.repo.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(private val userRepo: UserRepositoryImpl): ViewModel() {
    private val _userAuthorized = MutableStateFlow(false)
    val userAuthorized = _userAuthorized.asStateFlow()

    fun authorizeUser(userLoginInfo: UserLoginInfo) {
        viewModelScope.launch {
            val result = userRepo.loginUser(userLoginInfo)
            _userAuthorized.value = result.isSuccess
        }
    }
}