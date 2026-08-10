package android.ai.androidcodingassessment.presentation.postlist

import android.ai.androidcodingassessment.domain.model.Post
import android.ai.androidcodingassessment.domain.usecase.GetPostsUseCase
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class postListViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {
    private val  _state = mutableStateOf(PostListState())
    val state: State<PostListState> = _state

   init {
       getPosts()
   }


    fun getPosts() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
           getPostsUseCase().onSuccess {  posts ->
               _state.value = _state.value.copy(
                   posts = posts,
                   isLoading = false
               )
           }.onFailure { exception ->
              _state.value = _state.value.copy(
                  isLoading = false,
                  error = exception.message ?: "Something went wrong"
              )
           }
        }
    }
}



data class PostListState(
    val isLoading : Boolean = false,
    val posts : List<Post> = emptyList(),
    val error : String? = null
)