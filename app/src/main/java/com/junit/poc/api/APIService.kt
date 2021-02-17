package com.junit.poc.api

import com.follett.fss.searchread.feature.schoolpicker.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface APIService {

    @Headers("Accept: application/json")
    @GET("search/users?q=language")
    suspend fun getUserResponse(): UserResponse
}