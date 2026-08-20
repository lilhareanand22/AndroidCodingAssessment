package android.ai.androidcodingassessment.domain.usecase

import android.ai.androidcodingassessment.domain.model.Post
import android.ai.androidcodingassessment.domain.repository.PostRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetPostsUseCaseTest {
    private val repository: PostRepository = mockk()
    private val getPostsUseCase = GetPostsUseCase(repository)

    @Test
    fun `invoke should return success when repository return posts`() = runTest {
        // Given
        val posts = listOf(Post(id=1,title= "title", body = "body", userId = 1))
        coEvery { repository.getPosts() } returns posts
        //When
        val result = getPostsUseCase()
        //Then
        assertTrue(result.isSuccess)
        assertEquals(posts, result.getOrNull())

    }
    @Test
    fun `invoke should return failure when repository thrown exception`() = runTest {
        // Given
        val exception = Exception("Network error")
        coEvery { repository.getPosts()} throws exception

        // when
        val result = getPostsUseCase()

        //Then
        assertTrue(result.isFailure)
        assertEquals(exception,result.exceptionOrNull())
    }
}