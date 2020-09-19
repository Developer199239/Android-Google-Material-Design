package com.example.googlematerialdesgin.bottom_sheet_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.googlematerialdesgin.R
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.bottom_app_bar_activity.*

class BottomBarActivity : AppCompatActivity() {
    private val oneDp by lazy { resources.getDimensionPixelSize(R.dimen.one_dp).toFloat() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_app_bar_activity)
        title = "BottomAppBarActivity"
        setupButtons()
        setupBottomAppBarMenuAndNavigation()
    }

    private fun setupButtons() {
        fabAlignmentModeButton.setOnClickListener {
            val alignmentMode = if (bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                BottomAppBar.FAB_ALIGNMENT_MODE_END else BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            bottomAppBar.fabAlignmentMode = alignmentMode
        }
        fabAnimationModeButton.setOnClickListener {
            val animationMode = if (bottomAppBar.fabAnimationMode == BottomAppBar.FAB_ANIMATION_MODE_SCALE) {
                BottomAppBar.FAB_ANIMATION_MODE_SLIDE
            } else {
                BottomAppBar.FAB_ANIMATION_MODE_SCALE
            }
            bottomAppBar.fabAnimationMode = animationMode
        }
        increaseFabCradleMarginButton.setOnClickListener {
            val cradleMargin = (bottomAppBar.fabCradleMargin + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleMargin = cradleMargin
        }
        decreaseFabCradleMarginButton.setOnClickListener {
            val cradleMargin = (bottomAppBar.fabCradleMargin - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleMargin = cradleMargin
        }
        increaseFabCradleCornerRadiusButton.setOnClickListener {
            val cradleCornerRadius = (bottomAppBar.fabCradleRoundedCornerRadius + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleRoundedCornerRadius = cradleCornerRadius
        }
        decreaseFabCradleCornerRadiusButton.setOnClickListener {
            val cradleCornerRadius = (bottomAppBar.fabCradleRoundedCornerRadius - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleRoundedCornerRadius = cradleCornerRadius
        }
        increaseFabCradleVerticalOffsetButton.setOnClickListener {
            val cradleVerticalOffset = (bottomAppBar.cradleVerticalOffset + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.cradleVerticalOffset = cradleVerticalOffset
        }
        decreaseFabCradleVerticalOffsetButton.setOnClickListener {
            val cradleVerticalOffset = (bottomAppBar.cradleVerticalOffset - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.cradleVerticalOffset = cradleVerticalOffset
        }
    }

    private fun setupBottomAppBarMenuAndNavigation() {
        bottomAppBar.replaceMenu(R.menu.bottom_app_bar_menu)
        bottomAppBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Clicked menu item 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this, "Clicked menu item 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(this, "Clicked menu item 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        bottomAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Clicked navigation item", Toast.LENGTH_SHORT).show()

            var bottomSheetAppBar = BottomSheetNavigationFragment.newInstance()
            bottomSheetAppBar.show(supportFragmentManager,"Bottom Sheet Dialog Fragment")
        }
    }
}