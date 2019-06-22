package com.aloarte.kotlinlisttest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aloarte.kotlinlisttest.MainActivity
import com.aloarte.kotlinlisttest.R
import com.aloarte.kotlinlisttest.data.AccountAdapter
import com.aloarte.kotlinlisttest.model.Account
import com.aloarte.kotlinlisttest.model.AccountList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.InputStream

class ListFragment : Fragment() {

    //Save if the switch that hide the not visible accounts is selected
    private var hideInvisAccounts = false

    fun hideInvAccounts(hideInvAccounts: Boolean) {
        this.hideInvisAccounts = hideInvAccounts
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onStart() {
        initViews()
        super.onStart()
    }

    /**
     * Initialize the views of the ListFragment
     */
    private fun initViews() {
        //Build the AccountAdapter
        val adapter = AccountAdapter(context!!, getAccountsFromJson())

        btn_return_home.setOnClickListener { startHomeFragment() }
        lv_accounts.adapter = adapter
    }

    /**
     * Retrieve the list of Accounts, removing the not visible ones if the switch was selected
     */
    private fun getAccountsFromJson(): ArrayList<Account>{
        //Read the raw list of accounts
        val listAccounts = parseJson()

        //If the switch was selected, remove the not visible accounts
        return if (hideInvisAccounts) {
            removeNotVisible(listAccounts.accounts!!)
        } else listAccounts.accounts!!
    }

    /**
     * Remove the not visible accounts from the ArrayList of Account
     */
    private fun removeNotVisible(accounts: ArrayList<Account>): ArrayList<Account> {
        val retAccountList: ArrayList<Account> = ArrayList()

        //Iterate the list
        for(account in accounts){
            //Only if the element is visible is added to the new list
            if (account.isVisible!!){
                retAccountList.add(account)
            }
        }
        return retAccountList
    }

    /**
     * Start the HomeFragment by calling to MainActivity
     */
    private fun startHomeFragment() {
        (activity as MainActivity).startHomeFragment()
    }

    /**
     * Parse the data from the JSON into an AccountList
     */
    private fun parseJson() : AccountList {
        return Gson().fromJson(readJsonFromFile(), AccountList::class.java)
    }

    /**
     * Read the Json from the .json in assets
     */
    private fun readJsonFromFile(): String {
        return try {
            val inputStream: InputStream = context!!.assets.open("listdata.json")
            inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            ""
        }
    }


}