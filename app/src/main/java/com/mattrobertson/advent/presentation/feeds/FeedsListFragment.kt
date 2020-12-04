package com.mattrobertson.advent.presentation.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mattrobertson.advent.R

class FeedsListFragment : Fragment() {

	companion object {
		fun newInstance() = FeedsListFragment()
	}

	private val viewModel: FeedsListViewModel by viewModels()
	private lateinit var adapter: FeedsListAdapter

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		val view = inflater.inflate(R.layout.main_fragment, container, false)

		val recyclerView: RecyclerView = view.findViewById(R.id.feeds)

		adapter = FeedsListAdapter()

		recyclerView.adapter = adapter
		recyclerView.layoutManager = LinearLayoutManager(requireContext())
		recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.feeds.observe(viewLifecycleOwner) { feeds ->
			if (feeds.isNotEmpty()) {
				adapter.feedItems = feeds
				adapter.notifyDataSetChanged()
			}
		}

		viewModel.getFeeds()
	}

}