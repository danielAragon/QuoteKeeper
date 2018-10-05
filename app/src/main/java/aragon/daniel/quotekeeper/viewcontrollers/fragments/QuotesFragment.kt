package aragon.daniel.quotekeeper.viewcontrollers.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aragon.daniel.quotekeeper.R
import aragon.daniel.quotekeeper.models.Bookmark
import aragon.daniel.quotekeeper.models.Quote
import aragon.daniel.quotekeeper.viewcontrollers.adapters.QuotesAdapter
import kotlinx.android.synthetic.main.fragment_quotes.view.*

class QuotesFragment : Fragment() {
    var quotes = ArrayList<Quote>()
    lateinit var quotesRecyclerView: RecyclerView
    lateinit var quotesAdapter: QuotesAdapter
    lateinit var quotesLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quotes, container, false)

        Bookmark.listAllQuotes().forEach { it->
            quotes.add(Quote(it.quote,it.author,it.cat))
        }

        quotesRecyclerView = view.quotesRecyclerView
        quotesAdapter = QuotesAdapter(quotes, view.context)
        quotesLayoutManager = GridLayoutManager(view.context,1)

        quotesRecyclerView.adapter = quotesAdapter
        quotesRecyclerView.layoutManager = quotesLayoutManager



        return view
    }
}