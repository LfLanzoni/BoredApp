package ar.android.lflanzoni.boredapp.data.model

data class BoredActivity(
    val activity: String,
    val accessibility: String,
    val type: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: Int
)