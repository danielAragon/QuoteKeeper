package aragon.daniel.quotekeeper.viewcontrollers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aragon.daniel.quotekeeper.R
import aragon.daniel.quotekeeper.models.Quote
import kotlinx.android.synthetic.main.item_quote.view.*

class QuotesAdapter(var quotes: ArrayList<Quote>,
                    val context: Context) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.item_quote, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes.get(position)
        holder.updateFrom(quote)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val quoteTextView = view.quoteTextView
        fun updateFrom(quote: Quote){
            quoteTextView.text = quote.quote
        }
    }
}