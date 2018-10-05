package aragon.daniel.quotekeeper.network

import aragon.daniel.quotekeeper.models.Quote
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class QuotesAPI{
    companion object {
        val baseUrl = "https://talaikis.com/api/quotes/random/"
        fun fetchQuote(responseHandler: (Quote?) -> Unit,
                       errorHandler: (ANError?) -> Unit){
            AndroidNetworking
                    .get(baseUrl)
                    .build()
                    .getAsObject(Quote::class.java,
                            object: ParsedRequestListener<Quote?>{
                                override fun onResponse(response: Quote?) {
                                    responseHandler(response)
                                }
                                override fun onError(anError: ANError?) {
                                    errorHandler(anError)
                                }
                            })
        }
    }
}