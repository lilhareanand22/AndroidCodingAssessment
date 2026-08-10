package android.ai.androidcodingassessment.data.repository

import android.ai.androidcodingassessment.data.api.PostApi
import android.ai.androidcodingassessment.data.model.toDomainModel
import android.ai.androidcodingassessment.domain.model.Post
import android.ai.androidcodingassessment.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImp  @Inject constructor(
    private val postApi : PostApi
) : PostRepository{
    override suspend fun getPosts(): List<Post> {
        return postApi.getPosts().map { it.toDomainModel() }
    }
}