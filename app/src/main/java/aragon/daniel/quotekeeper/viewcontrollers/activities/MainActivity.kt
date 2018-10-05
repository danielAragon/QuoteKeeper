package aragon.daniel.quotekeeper.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import aragon.daniel.quotekeeper.R
import aragon.daniel.quotekeeper.viewcontrollers.fragments.HomeFragment
import aragon.daniel.quotekeeper.viewcontrollers.fragments.QuotesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }
    private fun navigateTo(item: MenuItem): Boolean{
        item.isChecked = true
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentFor(item))
                .commit() > 0
    }

    private fun fragmentFor(item: MenuItem): Fragment {
        when(item.itemId){
            R.id.navigation_home -> {
                return HomeFragment()
            }
            R.id.navigation_quotes -> {
                return QuotesFragment()
            }
        }
        return HomeFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home

    }
}
