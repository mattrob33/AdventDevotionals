package com.mattrobertson.advent.presentation.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mattrobertson.advent.domain.model.feeds.AdventFeed
import com.mattrobertson.advent.repo.FeedRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel : ViewModel() {

    private val repo = FeedRepo()

    private val _feed = MutableLiveData<AdventFeed?>()
    val feed: LiveData<AdventFeed?> = _feed

    fun getFeed(feedId: String) = viewModelScope.launch(Dispatchers.IO) {

        val feed = repo.getFeed(feedId)

        withContext(Dispatchers.Main) {
            _feed.value = feed
        }
    }
}