package com.saydullin.servers.mapper

import by.devsgroup.servers.model.ServerInfo
import com.saydullin.domain.mapper.Mapper
import com.saydullin.servers.api.model.ServerData
import javax.inject.Inject

class ServerDataToDomainMapper @Inject constructor(
): Mapper<ServerData, ServerInfo> {

    override fun map(from: ServerData): ServerInfo {
        return ServerInfo(
            common = from.name.common,
            official = from.name.official,
        )
    }

}