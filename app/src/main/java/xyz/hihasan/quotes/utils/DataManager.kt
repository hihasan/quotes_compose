package xyz.hihasan.quotes.utils

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import xyz.hihasan.quotes.models.QuoteModel

object DataManager {
    var data = emptyArray<QuoteModel>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context : Context){
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuoteModel>::class.java)
        isDataLoaded.value = true
    }

}