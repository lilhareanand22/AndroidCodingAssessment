package android.ai.androidcodingassessment.di

import android.ai.androidcodingassessment.data.api.PostApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun providePostApi(): PostApi {
        return Retrofit.Builder()
            .baseUrl(PostApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

}