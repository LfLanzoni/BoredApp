package ar.android.lflanzoni.boredapp.repository

import ar.android.lflanzoni.boredapp.data.model.BoredTask
import retrofit2.Response

interface Repository {
    suspend fun getBoredActivity(): Response<BoredTask>
    suspend fun getBoreadActivityFortype(type:String): Response<BoredTask>
}
