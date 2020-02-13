package database.pojo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import database.pojo.Sizes

@JsonClass(generateAdapter = true)
data class CatCover(
    @Json(name = "sizes")
    val sizes: Sizes
)