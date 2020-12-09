package com.mattrobertson.advent.presentation.feed

import android.text.Spanned
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mattrobertson.advent.AdventDevotionalsApplication
import com.mattrobertson.advent.data.repo.FeedRepo
import io.noties.markwon.Markwon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel : ViewModel() {

    private val context = AdventDevotionalsApplication.context

    private val marker = Markwon.create(context)

    private val repo = FeedRepo()

    private val _petitionMarkdown = MutableLiveData<Spanned?>(null)
    val petitionMarkdown: LiveData<Spanned?> = _petitionMarkdown

    fun getFeed(feedId: String) = viewModelScope.launch(Dispatchers.IO) {

        val feed = repo.getFeed(feedId)
        val todaysPetition = feed.getTodaysPetition()

        val petitionText = todaysPetition?.description ?: "*This devotional does not have any readings for today.*"
        val markdown = marker.toMarkdown(petitionText)

        withContext(Dispatchers.Main) {
            _petitionMarkdown.value = markdown
        }
    }
}