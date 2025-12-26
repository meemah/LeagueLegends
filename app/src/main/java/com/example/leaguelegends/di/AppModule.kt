package com.example.leaguelegends.di

import com.example.leaguelegends.domain.repository.ApiRepository
import com.example.leaguelegends.domain.repository.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient =
        HttpClient(OkHttp.create()){
            defaultRequest{
                url(ApiRepositoryImpl.baseUrl)
                headers {
                    append(HttpHeaders.ContentType,"application/json")
                }
            }
            install(ContentNegotiation){
                json(
                    Json{
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

    @Provides
    @Singleton
    fun  provideApiRepository(httpClient: HttpClient) : ApiRepository
      = ApiRepositoryImpl(httpClient = httpClient)
}