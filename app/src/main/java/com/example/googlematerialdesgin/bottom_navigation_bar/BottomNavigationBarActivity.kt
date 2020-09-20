package com.example.googlematerialdesgin.bottom_navigation_bar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.googlematerialdesgin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation_bar.*


class BottomNavigationBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_bar)
        initBottomNavigationView()
        openFragment(BottomNavHomeFragment.newInstance())
    }

    private fun initBottomNavigationView(){
        val list = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    Toast.makeText(this, "page_home", Toast.LENGTH_SHORT).show()
                    openFragment(BottomNavHomeFragment.newInstance())
                    true
                }
                R.id.page_library -> {
                    Toast.makeText(this, "page_library", Toast.LENGTH_SHORT).show()
                    openFragment(BottomNavLibraryFragment.newInstance())
                    true
                }
                R.id.page_radio -> {
                    Toast.makeText(this, "page_radio", Toast.LENGTH_SHORT).show()
                    openFragment(BottomNavRadioFragment.newInstance())
                    true
                }
                else -> false
            }
        }
        bottom_navigation.setOnNavigationItemSelectedListener(list)

        bottom_navigation.getOrCreateBadge(R.id.page_home)
        val badge = bottom_navigation.getBadge(R.id.page_home)
        badge!!.number = 10
    }

   private fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            transaction.replace(R.id.container, fragment)
        } else {
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
            return
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }
}