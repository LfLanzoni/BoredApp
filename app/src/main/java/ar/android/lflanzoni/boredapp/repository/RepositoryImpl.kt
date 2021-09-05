package ar.android.lflanzoni.boredapp.repository

import ar.android.lflanzoni.boredapp.data.model.Translate
import ar.android.lflanzoni.boredapp.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataSource: RemoteDataSource):Repository  {
     override suspend fun getBoredActivity() = dataSource.getBoredActivity()
     override suspend fun getBoreadActivityFortype(type:String) = dataSource.getBoreadActivityFortype(type)
     override suspend fun translateText(text: String): Response<Translate> = dataSource.translate(text)
}