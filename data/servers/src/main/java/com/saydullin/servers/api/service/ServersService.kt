package com.saydullin.servers.api.service

import com.saydullin.servers.api.model.ServerData
import retrofit2.Response
import retrofit2.http.GET

interface ServersService {

    @GET("v3.1/region/europe?fields=name")
    suspend fun getEuropeServers(): Response<List<ServerData>>

}


