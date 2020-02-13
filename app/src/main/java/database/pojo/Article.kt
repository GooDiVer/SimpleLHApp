package database.pojo


import androidx.annotation.Nullable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(

    @Json(name = "cat_cover")
    val catCover: CatCover,
    @Json(name = "content")
    val content: Content,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: Title
)