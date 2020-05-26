package com.victoryzzi.android.apps.choism.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubRepo(
    @Json(name = "name") val repoName: String,
    @Json(name = "description") val repoDescription: String?,
    @Json(name = "stargazers_count") val repoStarCount: String
)