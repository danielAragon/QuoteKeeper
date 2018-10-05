package aragon.daniel.quotekeeper;

import com.androidnetworking.AndroidNetworking
import com.orm.SugarApp

class QuoteKeeper: SugarApp() {
    override fun onCreate(){
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}
