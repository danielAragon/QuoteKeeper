package aragon.daniel.quotekeeper.models

import com.orm.SugarRecord

public class Bookmark: SugarRecord(){
    var quote: String = ""
    var author: String = ""
    var cat: String = ""
    companion object {
        fun listAllQuotes():List<Bookmark>{
            return listAll(Bookmark::class.java)
        }
    }
}