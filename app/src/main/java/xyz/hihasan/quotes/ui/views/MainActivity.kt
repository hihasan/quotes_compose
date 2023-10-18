package xyz.hihasan.quotes.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import xyz.hihasan.quotes.ui.screens.QuoteListScreen
import xyz.hihasan.quotes.ui.theme.QuotesTheme
import xyz.hihasan.quotes.utils.DataManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManager.loadAssetsFromFile(this)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    QuoteListScreen(data = DataManager.data) {}
}