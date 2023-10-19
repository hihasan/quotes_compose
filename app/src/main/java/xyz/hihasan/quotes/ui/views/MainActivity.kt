package xyz.hihasan.quotes.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.hihasan.quotes.ui.screens.QuoteDetails
import xyz.hihasan.quotes.ui.screens.QuoteListScreen
import xyz.hihasan.quotes.ui.theme.QuotesTheme
import xyz.hihasan.quotes.utils.DataManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTINGS){
            QuoteListScreen(data = DataManager.data) {

            }
        } else{
            QuoteDetails(quote = )
        }
        
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(
                text = "Loading....",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Thin
            )
        }
    }
}

enum class Pages{
    LISTINGS,
    DETAIL
}