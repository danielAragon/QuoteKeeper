package aragon.daniel.quotekeeper.viewcontrollers.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import aragon.daniel.quotekeeper.R
import aragon.daniel.quotekeeper.models.Quote
import aragon.daniel.quotekeeper.network.QuotesAPI
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private var quote: Quote? = null
    var isBookmarked: Boolean = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        QuotesAPI.fetchQuote(
                {response -> handleResponse(response,view)},
                {error -> handleError(error)})
        return view
    }

    fun updateBookmarkImage() {
        bookmarkImageButton.setImageResource(
                if (this.isBookmarked) {
                    R.drawable.ic_bookmark_black_24dp
                } else {
                    R.drawable.ic_bookmark_border_black_24dp
                })
    }

    private fun handleResponse(response: Quote?,view: View) {
        quote = Quote(response!!.quote,response.author,response.cat)
        view.quoteTextView.text = quote!!.quote
        isBookmarked = quote!!.isBookmarked()
        updateBookmarkImage()

        view.bookmarkImageButton.setOnClickListener{view ->
            isBookmarked = !isBookmarked
            quote!!.setBookmarked(isBookmarked)
            updateBookmarkImage()
        }
    }

    private fun handleError(anError: ANError?) {
        Log.d("CatchUp", anError!!.message)
    }
}
