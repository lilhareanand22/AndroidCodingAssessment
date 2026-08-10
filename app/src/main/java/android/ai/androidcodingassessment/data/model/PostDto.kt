package android.ai.androidcodingassessment.data.model

import android.ai.androidcodingassessment.domain.model.Post

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)


fun PostDto.toDomainModel() : Post {
    return Post(
        id = id,
        title = title,
        body=body,
        userId = userId
    )
}