package com.mattrobertson.advent.presentation.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import coil.load
import coil.transform.CircleCropTransformation
import com.mattrobertson.advent.R

class FeedFragment : Fragment() {

	companion object {
		fun newInstance() = FeedFragment()
	}

	private lateinit var viewModel: FeedViewModel

	private val args: FeedFragmentArgs by navArgs()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.feed_image_transition)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.feed_fragment, container, false)

		view.findViewById<TextView>(R.id.feedTitle).apply {
			transitionName = args.title
			text = args.title
		}

		view.findViewById<ImageView>(R.id.feedImg).transitionName = args.imageUrl

		view.findViewById<ImageView>(R.id.feedImg).load(args.imageUrl) {
			transformations(CircleCropTransformation())
		}

		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
		// TODO: Use the ViewModel
	}

}