package com.example.composeproject.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.mvvm.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo: Repo): ViewModel() {

    val category: StateFlow<List<String>> = repo.categories

    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }


}