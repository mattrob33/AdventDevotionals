package com.mattrobertson.advent.presentation.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.mattrobertson.advent.R
import com.mattrobertson.advent.domain.model.feeds.FeedListFeedItem
import com.mattrobertson.advent.domain.model.feeds.FeedListItem

class FeedsListAdapter: RecyclerView.Adapter<FeedsListAdapter.ViewHolder>() {

    var feedItems: List<FeedListItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = feedItems[position]

        if (item is FeedListFeedItem) {
            val imageView = viewHolder.feedImg
            imageView.load(item.imageUrl) {
                crossfade(750)
                scale(Scale.FILL)
                transformations(CircleCropTransformation())
            }
        }

        val titleView = viewHolder.feedTitle
        titleView.text = item.label
    }

    override fun getItemCount() = feedItems.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val feedImg: ImageView = itemView.findViewById(R.id.feedImg)
        val feedTitle: TextView = itemView.findViewById(R.id.feedTitle)
    }
}