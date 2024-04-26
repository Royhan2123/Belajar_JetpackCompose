package com.example.learngetapi.di

import android.app.Application
import com.example.learngetapi.data.manger.LocalUserMangerImpl
import com.example.learngetapi.domain.manger.LocalUserManger
import com.example.learngetapi.domain.usecases.AppEntryUseCases
import com.example.learngetapi.domain.usecases.ReadAppEntry
import com.example.learngetapi.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ) : LocalUserManger = LocalUserMangerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}