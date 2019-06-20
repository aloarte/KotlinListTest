package com.aloarte.kotlinlisttest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
    }

    fun startListFragment(hideInvAccSelected: Boolean) {
        val fragment = ListFragment()
        fragment.hideInvAccounts(hideInvAccSelected)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()

    }

    fun startHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

    }
}
