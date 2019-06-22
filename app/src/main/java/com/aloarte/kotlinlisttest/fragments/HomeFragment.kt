package com.aloarte.kotlinlisttest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aloarte.kotlinlisttest.MainActivity
import com.aloarte.kotlinlisttest.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    //Save if the switch that hide the not visible accounts is selected
    var hideInvAccounts = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        initViews()
        super.onStart()
    }

    /**
     * Initialize the views of the HomeFragment
     */
    private fun initViews() {

        btn_display_list.setOnClickListener { startListFragment(hideInvAccounts) }

        sw_hide_invis.setOnCheckedChangeListener { _, isChecked ->
            hideInvAccounts = isChecked
        }


    }

    /**
     * Start the ListFragment by calling to MainActivity
     */
    private fun startListFragment(hideInvAccSelected: Boolean) {
        (activity as MainActivity).startListFragment(hideInvAccSelected)
    }


}