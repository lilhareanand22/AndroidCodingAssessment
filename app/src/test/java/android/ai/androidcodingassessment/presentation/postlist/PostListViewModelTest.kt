package android.ai.androidcodingassessment.presentation.postlist

import android.ai.androidcodingassessment.domain.model.Post
import android.ai.androidcodingassessment.domain.usecase.GetPostsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PostListViewModelTest {

    private val getPostsUseCase: GetPostsUseCase = mockk()
    private lateinit var viewModel: PostListViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getPosts should update state with posts on success`() {
        // Given
        val posts = listOf(Post(id=1,title= "title", body = "body", userId = 1))
        coEvery { getPostsUseCase() } returns Result.success(posts)

        // When
        viewModel = PostListViewModel(getPostsUseCase)

        // Then
        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertEquals(posts, state.posts)
        assertEquals(null, state.error)
    }

    @Test
    fun `getPosts should update state with error on failure`() {
        // Given
        val errorMessage = "Network error"
        coEvery { getPostsUseCase() } returns Result.failure(Exception(errorMessage))

        // When
        viewModel = PostListViewModel(getPostsUseCase)

        // Then
        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertTrue(state.posts.isEmpty())
        assertEquals(errorMessage, state.error)
    }
}
