package com.victoryzzi.android.apps.choism.service

import com.victoryzzi.android.apps.choism.BASE_URL
import com.victoryzzi.android.apps.choism.model.GithubOwner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OwnerService {
    @GET("/users/{username}/")
    fun loadOwner(
        @Path("username")
        userName: String
    ): Call<GithubOwner>
}