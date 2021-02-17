package com.junit.poc.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.follett.fss.searchread.feature.schoolpicker.model.UserResponse
import com.junit.poc.feature.main.repostitory.UserRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserViewModel :  ViewModel(), KoinComponent {

    private val repository: UserRepository by inject()

    fun getUserInfo() = liveData {
        try {
            val userInfo = repository.getUserList()
            emit(Result.success(userInfo))
        } catch (error: Throwable) {
            emit(Result.failure<UserResponse>(error))
        } finally {
        }
    }
}