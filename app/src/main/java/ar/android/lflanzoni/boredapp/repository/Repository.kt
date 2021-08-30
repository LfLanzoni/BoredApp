package ar.android.lflanzoni.boredapp.repository

import ar.android.lflanzoni.boredapp.data.model.BoredActivity
import retrofit2.Response

interface Repository {
    suspend fun getBoredActivity(): Response<BoredActivity>
    suspend fun getBoreadActivityFortype(type:String): Response<BoredActivity>
}
