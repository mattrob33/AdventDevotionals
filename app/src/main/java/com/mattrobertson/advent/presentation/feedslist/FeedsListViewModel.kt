package com.mattrobertson.advent.presentation.feedslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mattrobertson.advent.domain.model.feeds.FeedListItem
import com.mattrobertson.advent.repo.FeedsListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedsListViewModel : ViewModel() {

    private val repo = FeedsListRepo()

    private val _feeds = MutableLiveData<List<FeedListItem>>(listOf())
    val feeds: LiveData<List<FeedListItem>> = _feeds

    fun getFeeds() = viewModelScope.launch(Dispatchers.IO) {

        val feeds = repo.getFeeds()

        withContext(Dispatchers.Main) {
            _feeds.value = feeds
        }
    }
}