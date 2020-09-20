package com.example.googlematerialdesgin.bottom_navigation_bar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.googlematerialdesgin.R
class BottomNavLibraryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav_library, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BottomNavLibraryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}