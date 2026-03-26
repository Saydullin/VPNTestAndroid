package com.saydullin.servers.api.model

import com.google.gson.annotations.SerializedName

data class ServerNameData(
    @SerializedName("common")
    val common: String,

    @SerializedName("official")
    val official: String,
)
