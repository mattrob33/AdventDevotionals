package com.mattrobertson.advent.domain.model.feeds

data class AdventFeed(
    val name: String,
    val description: String,
    val sampleChapterUrl: String,
    val petitions: List<Petition>,
)

data class Petition(
    val uid: String,
    val date: String,
    val title: String,
    val description: String,
    val markdown: Boolean
)