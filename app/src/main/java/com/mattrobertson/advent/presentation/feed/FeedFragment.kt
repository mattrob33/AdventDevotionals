package com.mattrobertson.advent.presentation.feed

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import coil.load
import coil.transform.CircleCropTransformation
import com.mattrobertson.advent.R
import com.mattrobertson.advent.utils.getTodaysDateHumanReadable

class FeedFragment : Fragment() {

	private val viewModel: FeedViewModel by viewModels()

	private val args: FeedFragmentArgs by navArgs()

	private lateinit var feedTextView: TextView
	private lateinit var feedLoadingProgress: ProgressBar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.feed_image_transition)
		sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.feed_image_transition)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.feed_fragment, container, false)

		feedLoadingProgress = view.findViewById(R.id.feedLoadingProgress)

		val todaysDateView = view.findViewById<TextView>(R.id.todaysDate)
		todaysDateView.apply {
			transitionName = "dateView"
			text = getTodaysDateHumanReadable()
		}

		feedTextView = view.findViewById(R.id.feedText)
		feedTextView.animate()
			.alpha(1f)
			.setDuration(1000)
			.setListener(null)

		view.findViewById<TextView>(R.id.feedTitle).apply {
			transitionName = args.title
			text = args.title
		}

		view.findViewById<ImageView>(R.id.feedImg).apply {
			transitionName = args.imageUrl
			load(args.imageUrl) {
				transformations(CircleCropTransformation())
			}
		}

		feedLoadingProgress.postDelayed({
			if (feedLoadingProgress.visibility == View.INVISIBLE)
				feedLoadingProgress.visibility = View.VISIBLE
		}, 100)

		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		feedTextView.movementMethod = LinkMovementMethod()

		viewModel.petitionMarkdown.observe(viewLifecycleOwner) { markdown ->
			markdown?.let {
				feedTextView.text = it
				feedLoadingProgress.visibility = View.GONE
				feedTextView.visibility = View.VISIBLE
			}
		}

		viewModel.getFeed(args.feedId)
	}

}