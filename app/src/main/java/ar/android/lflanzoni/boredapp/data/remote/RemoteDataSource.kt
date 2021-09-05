package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.BoredTask
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getBoredActivity(): Response<BoredTask>
    suspend fun getBoreadActivityFortype(type:String): Response<BoredTask>

}
