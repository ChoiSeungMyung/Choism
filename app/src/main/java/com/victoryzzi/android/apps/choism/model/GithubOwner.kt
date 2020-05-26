package com.victoryzzi.android.apps.choism.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubOwner(
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "name") val ownerName: String
)