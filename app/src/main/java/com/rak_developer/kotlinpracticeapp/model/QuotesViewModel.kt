package com.rak_developer.kotlinpracticeapp.model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class QuotesViewModel(val context: Context) : ViewModel() {

    private var quoteList: Array<QuotesModel> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<QuotesModel> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<QuotesModel>::class.java)
    }

    fun getQuotes() = quoteList[index]

    fun nextQuotes() = quoteList[++index]

    fun previousQuotes() = quoteList[--index]

    fun getQuotesStart(): QuotesModel {
        return quoteList[index];
    }

    fun nextQuotes1(): QuotesModel {
        if (index == 0 || index < quoteList.size) {
            return quoteList[++index];
        } else {
            index == 0;
            return quoteList[index];
        }
    }

    fun previousQuotes1(): QuotesModel {
        if (index < quoteList.size && index != 0) {
            return quoteList[--index];
        } else {
            index = quoteList.size
            return quoteList[index];
        }
    }

}