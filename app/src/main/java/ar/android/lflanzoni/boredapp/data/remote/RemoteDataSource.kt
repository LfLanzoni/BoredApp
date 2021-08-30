package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.BoredActivity
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getBoredActivity(): Response<BoredActivity>
    suspend fun getBoreadActivityFortype(type:String): Response<BoredActivity>

}
