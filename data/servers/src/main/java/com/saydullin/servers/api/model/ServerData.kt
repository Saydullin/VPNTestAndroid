package com.saydullin.servers.api.model;

import com.google.gson.annotations.SerializedName;

data class ServerData(
    @SerializedName("name")
    val name: ServerNameData
)


