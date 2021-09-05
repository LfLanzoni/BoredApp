package ar.android.lflanzoni.boredapp.repository

import ar.android.lflanzoni.boredapp.data.model.BoredTask
import ar.android.lflanzoni.boredapp.data.model.Translate
import retrofit2.Response

interface Repository {
    suspend fun getBoredActivity(): Response<BoredTask>
    suspend fun getBoreadActivityFortype(type: String): Response<BoredTask>
    suspend fun translateText(text: String): Response<Translate>
}
