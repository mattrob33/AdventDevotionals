package com.mattrobertson.advent.presentation.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
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
            val titleView = viewHolder.feedTitle

            imageView.transitionName = item.imageUrl

            imageView.load(item.imageUrl) {
                crossfade(750)
                scale(Scale.FILL)
                transformations(CircleCropTransformation())
            }

            viewHolder.feedRow.setOnClickListener {
                val navController = viewHolder.feedRow.findNavController()

                val extras = FragmentNavigatorExtras(
                    imageView to item.imageUrl,
                    titleView to item.label
                )

                val action = FeedsListFragmentDirections.toFeedFragment(item.label, item.imageUrl)
                navController.navigate(action, extras)
            }
        }

        val titleView = viewHolder.feedTitle
        titleView.apply {
            text = item.label
            transitionName = item.label
        }
    }

    override fun getItemCount() = feedItems.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val feedRow: ConstraintLayout = itemView.findViewById(R.id.feedRow)
        val feedImg: ImageView = itemView.findViewById(R.id.feedImg)
        val feedTitle: TextView = itemView.findViewById(R.id.feedTitle)
    }
}