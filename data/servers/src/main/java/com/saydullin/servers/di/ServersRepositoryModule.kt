package com.saydullin.servers.di

import by.devsgroup.servers.repository.ServerRepository
import com.saydullin.servers.repository.ServerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServersRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindServerRepository(
        serverRepository: ServerRepositoryImpl
    ): ServerRepository

}


