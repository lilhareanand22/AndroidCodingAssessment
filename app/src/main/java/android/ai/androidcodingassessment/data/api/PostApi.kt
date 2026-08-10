package android.ai.androidcodingassessment.data.api

import android.ai.androidcodingassessment.data.model.PostDto
import retrofit2.http.GET


interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>


    companion object {
        const val BASE_URL= "https://jsonplaceholder.typicode.com/"
    }
}