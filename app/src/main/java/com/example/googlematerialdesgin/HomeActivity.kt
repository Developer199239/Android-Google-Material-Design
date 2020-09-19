package com.example.googlematerialdesgin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.googlematerialdesgin.bottom_sheet_bar.BottomBarActivity
import com.example.googlematerialdesgin.top_app_bar.TopAppBarActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_bottomappbar.setOnClickListener {
            var intent = Intent(this@HomeActivity, BottomBarActivity::class.java)
            startActivity(intent)
        }

        btn_top_app_bar.setOnClickListener {
            var intent = Intent(this@HomeActivity, TopAppBarActivity::class.java)
            startActivity(intent)
        }
    }
}