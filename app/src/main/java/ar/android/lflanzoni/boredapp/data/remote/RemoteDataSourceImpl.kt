package ar.android.lflanzoni.boredapp.data.remote

import ar.android.lflanzoni.boredapp.data.model.BoredTask
import ar.android.lflanzoni.boredapp.data.model.Translate
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val activityBoredService: BoredActivityService,
    private val translateService: TranslateService,
) : RemoteDataSource {
    override suspend fun getBoredActivity(): Response<BoredTask> =
        activityBoredService.getBoredActivity()

    override suspend fun getBoreadActivityFortype(type: String): Response<BoredTask> =
        activityBoredService.getBoredActivityForType(type)

    override suspend fun translate(text: String): Response<Translate> =
        translateService.translate("xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx", text, "en", "es")
}