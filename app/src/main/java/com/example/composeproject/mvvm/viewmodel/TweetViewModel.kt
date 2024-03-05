package com.example.composeproject.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.mvvm.model.Tweet
import com.example.composeproject.mvvm.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(private val repo: Repo): ViewModel() {

    val tweets: StateFlow<List<Tweet>> = repo.tweets

    init {
        viewModelScope.launch {
//            repo.getTweets()
        }
    }


}