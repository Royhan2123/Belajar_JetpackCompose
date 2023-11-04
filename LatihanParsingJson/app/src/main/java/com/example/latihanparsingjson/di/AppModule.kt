package com.example.latihanparsingjson.di

import com.example.latihanparsingjson.model.Question
import com.example.latihanparsingjson.network.QuestionApi
import com.example.latihanparsingjson.repository.QuestionRepository
import com.example.latihanparsingjson.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesQuotesApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }

    @Singleton
    @Provides
    fun providesQuestionRepository(api: QuestionApi) = QuestionRepository(api)
}