package com.victoryzzi.android.apps.choism.service

import com.victoryzzi.android.apps.choism.BASE_URL
import com.victoryzzi.android.apps.choism.model.GithubOwner
import com.victoryzzi.android.apps.choism.model.GithubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoService {
    @GET("users/{username}/repos")
    fun loadRepos(
        @Path("username")
        userName: String
    ): Call<List<GithubRepo>>
}