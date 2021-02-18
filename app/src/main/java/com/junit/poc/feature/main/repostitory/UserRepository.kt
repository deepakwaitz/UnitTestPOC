package com.junit.poc.feature.main.repostitory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.follett.fss.searchread.feature.schoolpicker.model.UserResponse
import com.junit.poc.api.APIError
import retrofit2.HttpException

class UserRepository:BaseRepository() {

    suspend fun getUserList() : UserResponse{
        val result: UserResponse
        try {
            result=getReaderServerAPI().getUserResponse()
        }catch (cause :Throwable){
            if(cause is HttpException){
                throw APIError(cause)
            }
            throw APIError("Unable to get user details ", null, cause)
        }
        return result
    }
}