package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.Translate
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslateService {
    @POST("/translate")
    suspend fun translate(
        @Query("api_key") key:String,
        @Query("q") text:String,
        @Query("source") source:String,
        @Query("target") target:String
    ): Response<Translate>
}