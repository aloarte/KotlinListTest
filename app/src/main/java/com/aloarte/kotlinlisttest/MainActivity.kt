package com.aloarte.kotlinlisttest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aloarte.kotlinlisttest.fragments.HomeFragment
import com.aloarte.kotlinlisttest.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set the HomeFragment as the initial one
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            HomeFragment()
        ).commit()
    }

    /**
     * Starts the ListFragment
     */
    fun startListFragment(hideInvAccSelected: Boolean) {
        val fragment = ListFragment()
        fragment.hideInvAccounts(hideInvAccSelected)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()

    }

    /**
     * Starts the HomeFragment
     */
    fun startHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            HomeFragment()
        ).commit()

    }
}
