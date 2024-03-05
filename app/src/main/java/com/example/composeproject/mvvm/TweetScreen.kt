package com.example.composeproject.mvvm

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeproject.mvvm.viewmodel.TweetViewModel

@Composable
fun TweetScreen() {
    val viewModel: TweetViewModel = viewModel()
    val tweet = viewModel.tweets.collectAsState()
    LazyColumn {
        items(tweet.value) {
            TweetItem(tweet = it.text)
        }
    }
}

@Composable
fun TweetItem(tweet: String) {
    Card(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(1f),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.body2
        )
    }
}