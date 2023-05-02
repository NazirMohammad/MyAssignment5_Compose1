package com.example.myassignment5_compose.di

import com.example.myassignment5_compose.data.remote.ApiDetails
import com.example.myassignment5_compose.data.remote.ApiRequest
import com.example.myassignment5_compose.data.repository.Repository
import com.example.myassignment5_compose.data.repository.RepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //Getting a GSON object
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    //Creating the OKHttpClient for interception
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    //Creating the Retrofit client
    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        provideOkHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.Base_Url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(provideOkHttpClient)
            .build()
    }

    //Using Retrofit to get the API call
    @Provides
    fun provideApi(
        retrofit: Retrofit
    ): ApiRequest {
        return retrofit.create(ApiRequest::class.java)
    }

    //Merging the repository class together
    @Provides
    fun provideRepository(
        apiRequest: ApiRequest
    ): Repository {
        return RepositoryImp(apiRequest)
    }



}