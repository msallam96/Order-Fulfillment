package com.ucs.picker.login.di

import com.ucs.picker.login.data.LoginRemoteDS
import com.ucs.picker.login.domain.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
class LoginModule {
    @Provides
    fun provideLoginRemoteDS(retrofit: Retrofit): LoginRemoteDS =
        retrofit.create(LoginRemoteDS::class.java)

    @Provides
    fun provideLoginRepository(loginRemoteDS: LoginRemoteDS) = LoginRepository(loginRemoteDS)
}