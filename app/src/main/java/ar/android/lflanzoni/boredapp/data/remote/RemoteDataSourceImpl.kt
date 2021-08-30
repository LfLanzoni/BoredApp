package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.BoredActivity
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val activityBoredService: BoredActivityService,
    private val translateService: TranslateService,
):RemoteDataSource {
    override suspend fun getBoredActivity(): Response<BoredActivity> = activityBoredService.getBoredActivity()
    override suspend fun getBoreadActivityFortype(type:String): Response<BoredActivity> = activityBoredService.getBoredActivityForType(type)
}