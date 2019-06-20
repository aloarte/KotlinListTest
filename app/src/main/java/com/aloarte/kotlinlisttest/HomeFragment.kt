package com.aloarte.kotlinlisttest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


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

    private fun initViews() {
        btn_display_list.setOnClickListener { startListFragment(hideInvAccounts) }

        sw_hide_invis.setOnCheckedChangeListener { _, isChecked ->
            hideInvAccounts = isChecked
        }


    }

    private fun startListFragment(hideInvAccSelected: Boolean) {
//        activity.startListFragment(hideInvAccSelected)
        (activity as MainActivity).startListFragment(hideInvAccSelected)
    }


}