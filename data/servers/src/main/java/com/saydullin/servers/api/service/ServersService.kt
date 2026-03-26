package com.saydullin.servers.api.service

import retrofit2.http.GET

interface ServersService {

    @GET("v3.1/all")
    fun getServers()

}