package android.ai.androidcodingassessment

import android.ai.androidcodingassessment.presentation.postlist.PostListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.ai.androidcodingassessment.ui.theme.AndroidCodingAssessmentTheme
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCodingAssessmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Box(modifier = Modifier.padding(innerPadding)){
                       PostListScreen()
                   }
                }
            }
        }
    }
}

