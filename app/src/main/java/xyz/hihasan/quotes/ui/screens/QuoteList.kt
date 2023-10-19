package xyz.hihasan.quotes.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import xyz.hihasan.quotes.models.QuoteModel

@Composable
fun QuoteList(data : Array<QuoteModel>, onClick: ()-> Unit) {

    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onClick)
        }
    })
}