package com.saydullin.servers.repository

import by.devsgroup.servers.model.ServerInfo
import by.devsgroup.servers.repository.ServerRepository
import com.saydullin.domain.resource.Resource
import com.saydullin.servers.api.service.ServersService
import com.saydullin.servers.mapper.ServerDataToDomainMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServerRepositoryImpl @Inject constructor(
    private val serversService: ServersService,
    private val serverDataToDomainMapper: ServerDataToDomainMapper,
): ServerRepository {

    override suspend fun getEuropeServers(): Resource<List<ServerInfo>> {
        return try {
            val europeServersResponse = withContext(Dispatchers.IO) {
                serversService.getEuropeServers()
            }
            val europeServers = europeServersResponse.body()

            if (!europeServersResponse.isSuccessful || europeServers == null) {
                return Resource.Error(
                    status = "Server list failure"
                )
            }

            val europeDomainServers = europeServers.map { serverDataToDomainMapper.map(it) }

            Resource.Success(europeDomainServers)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                e = e
            )
        }
    }

}


