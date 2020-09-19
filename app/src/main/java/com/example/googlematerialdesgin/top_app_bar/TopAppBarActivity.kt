package com.example.googlematerialdesgin.top_app_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.googlematerialdesgin.R
import kotlinx.android.synthetic.main.activity_top_app_bar.*

class TopAppBarActivity : AppCompatActivity() {
    var actionMode: ActionMode? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_app_bar)
        setupTopAppBar()
        contextualActionBar()



        tv_actionMode.setOnLongClickListener(View.OnLongClickListener {
            if (actionMode == null) actionMode = startActionMode(callback)
            actionMode?.title = "1 selected"
            return@OnLongClickListener true
        })
    }


    private fun contextualActionBar(){
//        val actionMode = startSupportActionMode(callback)

    }


    val callback = object : ActionMode.Callback {

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.contextual_action_bar, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return when (item?.itemId) {
                R.id.share -> {
                    // Handle share icon press
                    true
                }
                R.id.delete -> {
                    // Handle delete icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
        }
    }

    private fun setupTopAppBar() {
        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Clicked navigation item", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }
}