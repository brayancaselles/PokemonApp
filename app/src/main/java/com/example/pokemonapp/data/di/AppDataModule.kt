package com.example.pokemonapp.data.di

import com.example.pokemonapp.data.datasource.IRemoteDataSource
import com.example.pokemonapp.data.remote.RemoteDataSource
import com.example.pokemonapp.data.remote.network.ApiService
import com.example.pokemonapp.data.remote.network.IApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDataModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource

    @Binds
    abstract fun bindApiService(apiService: ApiService): IApiService
}
