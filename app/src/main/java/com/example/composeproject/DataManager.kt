package com.example.composeproject

import android.content.Context
import com.example.composeproject.model.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    fun loadAssetFromFile(context: Context): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return Gson().fromJson<Array<Quote>>(json, Array<Quote>::class.java)
    }
}