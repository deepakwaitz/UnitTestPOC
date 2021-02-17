package com.junit.poc.feature.main.repostitory

import android.content.Context
import com.junit.poc.api.APIService
import com.junit.poc.api.APIServiceFactory
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepository : KoinComponent{

    fun getReaderServerAPI(): APIService {
        return APIServiceFactory.getApiService()
    }

}