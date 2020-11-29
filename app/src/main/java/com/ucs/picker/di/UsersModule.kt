package com.ucs.picker.di

import com.ucs.picker.data.UsersRemoteDS
import com.ucs.picker.domain.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
class UsersModule {
    @Provides
    fun provideUsersRemoteDS(retrofit: Retrofit): UsersRemoteDS =
        retrofit.create(UsersRemoteDS::class.java)

    @Provides
    fun provideUsersRepository(usersRemoteDS: UsersRemoteDS) = UsersRepository(usersRemoteDS)
}