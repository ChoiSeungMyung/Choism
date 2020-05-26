package com.victoryzzi.android.apps.choism.service

import com.squareup.moshi.Moshi
import com.victoryzzi.android.apps.choism.BASE_URL
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
object NetworkHelper {
    private val okhttp by lazy {
        OkHttpClient.Builder().build()
    }

    private val moshi by lazy {
        Moshi.Builder()
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(okhttp)
            .build()
    }

    val ownerService: OwnerService by lazy {
        retrofit.create(
            OwnerService::class.java)
    }

    val repoService: RepoService by lazy {
        retrofit.create(
            RepoService::class.java
        )
    }
}