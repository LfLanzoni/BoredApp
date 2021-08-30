package ar.android.lflanzoni.boredapp.di

import ar.android.lflanzoni.boredapp.BuildConfig
import ar.android.lflanzoni.boredapp.data.remote.BoredActivityService
import ar.android.lflanzoni.boredapp.data.remote.RemoteDataSource
import ar.android.lflanzoni.boredapp.data.remote.RemoteDataSourceImpl
import ar.android.lflanzoni.boredapp.data.remote.TranslateService
import ar.android.lflanzoni.boredapp.repository.Repository
import ar.android.lflanzoni.boredapp.repository.RepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideBaseBoredUrl() = BuildConfig.BASE_BORED_URL

    @Provides
    fun provideBaseTranslateUrl() = BuildConfig.BASE_TRANSLATE_URL

    @Provides
    @Singleton
    @Named("Normal")
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BuildConfig.BASE_BORED_URL)
            .build()

    @Provides
    @Singleton
    @Named("Translate")
    fun provideRetrofitTranslate(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BuildConfig.BASE_TRANSLATE_URL)
            .build()

    @Provides
    @Singleton
    fun provideBoredService(@Named("Normal")retrofit: Retrofit) = retrofit.create(BoredActivityService::class.java)

    @Provides
    @Singleton
    fun provideTranslateService(@Named("Translate")retrofit: Retrofit) = retrofit.create(TranslateService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl):RemoteDataSource = remoteDataSource

    @Provides
    @Singleton
    fun provideRepository(repository: RepositoryImpl): Repository = repository
}