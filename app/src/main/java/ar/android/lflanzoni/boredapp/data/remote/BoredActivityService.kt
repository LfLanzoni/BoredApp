package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.BoredTask
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredActivityService {

    @GET("/api/activity/")
    suspend fun getBoredActivity(): Response<BoredTask>

    @GET("/api/activity/")
    suspend fun getBoredActivityForType(
        @Query("type") type:String
    ): Response<BoredTask>


}