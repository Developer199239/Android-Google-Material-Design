package com.example.googlematerialdesgin.tab_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.googlematerialdesgin.R
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TabHomeFragment.newInstance("",""), "Home")
        adapter.addFragment(TabLibraryFragment.newInstance("",""), "Library")
        adapter.addFragment(TabPowerFragment.newInstance("",""), "Power")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        //set icons
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_library_music_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_power_settings_new_24)
        //set badge
//        var badgeMusic = tabs.getTabAt(0)!!.orCreateBadge
//        badgeMusic.isVisible = true
//        badgeMusic.number = 12
    }
}


class ViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}