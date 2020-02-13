package database.pojo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sizes(
    @Json(name = "mobile")
    val mobile: Any?
)