package api

import database.pojo.Article
import retrofit2.Response
import retrofit2.http.GET

interface LHService {
    @GET("/api/wp/v2/posts")
    suspend fun getPosts(): Response<List<Article>>
}