package android.ai.androidcodingassessment.domain.usecase

import android.ai.androidcodingassessment.domain.model.Post
import android.ai.androidcodingassessment.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke() : Result<List<Post>> = runCatching {
        repository.getPosts()
    }
}