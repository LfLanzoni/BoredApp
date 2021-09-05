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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    @Named("Normal")
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BuildConfig.BASE_BORED_URL)
            .client(provideOkHttpClient())
            .build()

    @Provides
    @Singleton
    @Named("Translate")
    fun provideRetrofitTranslate(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BuildConfig.BASE_TRANSLATE_URL)
            .client(provideOkHttpClient())
            .build()

    @Provides
    @Singleton
    fun provideBoredService(@Named("Normal")retrofit: Retrofit): BoredActivityService = retrofit.create(BoredActivityService::class.java)

    @Provides
    @Singleton
    fun provideTranslateService(@Named("Translate")retrofit: Retrofit): TranslateService = retrofit.create(TranslateService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl):RemoteDataSource = remoteDataSource

    @Provides
    @Singleton
    fun provideRepository(repository: RepositoryImpl): Repository = repository
}