package com.mattrobertson.advent.presentation.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mattrobertson.advent.R

class FeedsListFragment : Fragment() {

	companion object {
		fun newInstance() = FeedsListFragment()
	}

	private val viewModel: FeedsListViewModel by viewModels()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		return inflater.inflate(R.layout.main_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.feeds.observe(this) { feeds ->
			if (feeds.size > 1)
				Toast.makeText(requireContext(), feeds[1].label, Toast.LENGTH_LONG).show()
		}

		viewModel.getFeeds()
	}

}