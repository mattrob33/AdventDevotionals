package com.mattrobertson.advent.presentation.feedslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mattrobertson.advent.R
import com.mattrobertson.advent.utils.getTodaysDateHumanReadable

class FeedsListFragment : Fragment() {

	private val viewModel: FeedsListViewModel by viewModels()
	private lateinit var adapter: FeedsListAdapter

	lateinit var progressBar: ProgressBar

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		val view = inflater.inflate(R.layout.feed_list_fragment, container, false)

		val todaysDateView = view.findViewById<TextView>(R.id.todaysDate)
		todaysDateView.text = getTodaysDateHumanReadable()

		val recyclerView: RecyclerView = view.findViewById(R.id.feeds)
		progressBar = view.findViewById(R.id.feedListLoadingProgress)

		adapter = FeedsListAdapter(todaysDateView)

		recyclerView.adapter = adapter
		recyclerView.layoutManager = LinearLayoutManager(requireContext())
		recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

		recyclerView.apply {
			postponeEnterTransition()
			viewTreeObserver
				.addOnPreDrawListener {
					startPostponedEnterTransition()
					true
				}
		}

		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.feeds.observe(viewLifecycleOwner) { feeds ->
			if (feeds.isNotEmpty()) {
				progressBar.visibility = View.GONE
				adapter.feedItems = feeds
				adapter.notifyDataSetChanged()
			}
		}

		viewModel.getFeeds()
	}

}