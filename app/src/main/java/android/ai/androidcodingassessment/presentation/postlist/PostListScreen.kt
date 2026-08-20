package android.ai.androidcodingassessment.presentation.postlist
import android.ai.androidcodingassessment.domain.model.Post
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PostListScreen(
    viewModel: PostListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
   Box(modifier = Modifier.fillMaxSize()) {
       LazyColumn(modifier = Modifier.fillMaxSize()) {
           items(state.posts) { post ->
              ItemsPost(post = post)
           }
       }

       if(state.error != null) {
           Text(
              text = state.error,
              color = MaterialTheme.colorScheme.error,
              modifier = Modifier.fillMaxSize()
                  .padding(20.dp)
                  .align(Alignment.Center)

           )
       }

       if(state.isLoading) {
           CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
       }
   }

}

@Composable
fun ItemsPost(post: Post) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(16.dp)) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}




