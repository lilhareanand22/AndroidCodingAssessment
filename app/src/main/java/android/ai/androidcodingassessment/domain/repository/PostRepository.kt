package android.ai.androidcodingassessment.domain.repository

import android.ai.androidcodingassessment.domain.model.Post

interface PostRepository {
    suspend fun getPosts() : List<Post>
}