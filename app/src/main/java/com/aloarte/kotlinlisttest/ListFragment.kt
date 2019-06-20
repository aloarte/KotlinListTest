package com.aloarte.kotlinlisttest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    var hideInvisAccounts = false

    fun hideInvAccounts(hideInvAccounts: Boolean) {
        this.hideInvisAccounts = hideInvAccounts
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (hideInvisAccounts) Toast.makeText(activity, "True", Toast.LENGTH_SHORT).show()
        else Toast.makeText(activity, "False", Toast.LENGTH_SHORT).show()

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onStart() {
        initViews()
        super.onStart()
    }

    private fun initViews() {
        btn_return_home.setOnClickListener { startHomeFragment() }
    }

    private fun startHomeFragment() {
        (activity as MainActivity).startHomeFragment()
    }


}