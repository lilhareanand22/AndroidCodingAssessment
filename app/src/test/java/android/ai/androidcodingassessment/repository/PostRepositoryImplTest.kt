package android.ai.wiproassistmentexample.data.repository

import android.ai.androidcodingassessment.data.api.PostApi
import android.ai.androidcodingassessment.data.model.PostDto
import android.ai.androidcodingassessment.data.repository.PostRepositoryImp

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class PostRepositoryImplTest {

    private val api: PostApi = mockk()
    private val repository = PostRepositoryImp(api)

    @Test
    fun `getPosts should return posts from api`() = runBlocking {
        // Given
        val postDtos = listOf(PostDto(id=1, title = "title", body="body", userId = 1))
        coEvery { api.getPosts() } returns postDtos

        // When
        val result = repository.getPosts()

        // Then
        assertEquals(1, result.size)
        assertEquals("title", result[0].title)
        assertEquals(1, result[0].id)
    }
}
