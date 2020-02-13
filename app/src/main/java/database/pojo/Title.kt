package database.pojo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Title(
    @Json(name = "rendered")
    val rendered: String
)