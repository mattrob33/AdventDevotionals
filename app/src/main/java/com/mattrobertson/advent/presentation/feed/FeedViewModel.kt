package com.mattrobertson.advent.presentation.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mattrobertson.advent.data.repo.FeedRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel : ViewModel() {

    private val repo = FeedRepo()

    private val _petitionMarkdown = MutableLiveData("")
    val petitionMarkdown: LiveData<String> = _petitionMarkdown

    fun getFeed(feedId: String) = viewModelScope.launch(Dispatchers.IO) {

        val feed = repo.getFeed(feedId)
        val todaysPetition = feed.getTodaysPetition()
        val reading = todaysPetition?.description ?: "*This devotional does not have any readings for today.*"

        withContext(Dispatchers.Main) {
            _petitionMarkdown.value = reading
        }
    }
}