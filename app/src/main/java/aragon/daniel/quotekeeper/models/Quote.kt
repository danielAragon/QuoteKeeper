package aragon.daniel.quotekeeper.models

import com.orm.SugarRecord

data class Quote(
        val quote: String?,
        val author: String?,
        val cat: String?) {


    fun isBookmarked(): Boolean{
        return SugarRecord
                .find(Bookmark::class.java,
                        "quote = ?",
                        quote).size > 0
    }
    fun setBookmarked(isBookmarked: Boolean){
        if (isBookmarked == isBookmarked()){
            return
        }
        if(isBookmarked){
            val bookmark = Bookmark()
            bookmark.quote = quote!!
            bookmark.author = author!!
            bookmark.cat = cat!!
            bookmark.save()
        } else {
            val bookmarks = SugarRecord
                    .find(Bookmark::class.java,
                            "quote = ?",
                            quote)
            bookmarks.forEach { it.delete() }
        }
    }
}



