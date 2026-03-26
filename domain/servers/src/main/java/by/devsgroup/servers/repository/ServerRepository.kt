package by.devsgroup.servers.repository

import by.devsgroup.servers.model.ServerInfo
import com.saydullin.domain.resource.Resource

interface ServerRepository {

    suspend fun getEuropeServers(): Resource<List<ServerInfo>>

}


