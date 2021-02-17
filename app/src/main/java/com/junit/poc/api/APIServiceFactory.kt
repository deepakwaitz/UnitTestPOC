package com.junit.poc.api

import android.content.Context
import com.junit.poc.utils.Constants
import com.junit.poc.utils.Constants.Companion.HTTP_CONNECTION_TIMEOUT
import com.junit.poc.utils.Constants.Companion.HTTP_READ_TIMEOUT
import com.junit.poc.utils.Constants.Companion.HTTP_WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIServiceFactory {
    companion object {
        private var _apiService: APIService? = null

        fun seApiService_testOnly(service: APIService?) {
            _apiService = service
        }

        fun getApiService(): APIService {
            return _apiService ?: buildRetrofitForService().create(APIService::class.java)
        }

        private fun buildRetrofitForService(): Retrofit {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                // We really shouldn't log anything if we're in release mode
                logging.level = HttpLoggingInterceptor.Level.NONE
            }

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
