package com.geo.album.service.album

import androidx.databinding.library.baseAdapters.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by George Thomas on 29/9/21
 */
class ApiBuilder {

    private var retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())

    private val httpClientBuilder = OkHttpClient.Builder()
    private lateinit var retrofit: Retrofit

    private fun buildClient() {
        retrofitBuilder.client(
            httpClientBuilder.readTimeout(
                TIMEOUT_DURATION,
                TimeUnit.MINUTES
            ).connectTimeout(
                TIMEOUT_DURATION,
                TimeUnit.MINUTES
            ).build()
        )
        retrofit = retrofitBuilder.build()
    }

    fun <T> getService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    companion object {

        private var INSTANCE: ApiBuilder? = null
        private const val TIMEOUT_DURATION: Long = 3

        fun getInstance(
            baseUrl: String
        ): ApiBuilder {
            if (INSTANCE == null) {
                INSTANCE = ApiBuilder()
                INSTANCE?.retrofitBuilder?.baseUrl(baseUrl)
                if (BuildConfig.DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    INSTANCE?.httpClientBuilder?.addInterceptor(interceptor)
                }
                INSTANCE?.buildClient()
            }
            return INSTANCE!!
        }
    }

}