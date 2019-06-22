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

class ListFragment : Fragment() {

    //Save if the switch that hide the not visible accounts is selected
    var hideInvisAccounts = false

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
        if(hideInvisAccounts){
            return removeNotVisible(listAccounts.accounts!!)
        }
        else return listAccounts.accounts!!
    }

    /**
     * Remove the not visible accounts from the ArrayList of Account
     */
    private fun removeNotVisible(accounts: ArrayList<Account>): ArrayList<Account> {
        var retAccountList: ArrayList<Account> =  ArrayList()

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
        var jsonString = "{\n" +
                "  \"accounts\": [\n" +
                "    {\n" +
                "      \"accountBalanceInCents\": 985000,\n" +
                "      \"accountCurrency\": \"EUR\",\n" +
                "      \"accountId\": 748757694,\n" +
                "      \"accountName\": \"Hr P L G N StellingTD\",\n" +
                "      \"accountNumber\": 748757694,\n" +
                "      \"accountType\": \"PAYMENT\",\n" +
                "      \"alias\": \"\",\n" +
                "      \"isVisible\": true,\n" +
                "      \"iban\": \"NL23INGB0748757694\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"accountBalanceInCents\": 1000000,\n" +
                "      \"accountCurrency\": \"EUR\",\n" +
                "      \"accountId\": 700000027559,\n" +
                "      \"accountName\": \",\",\n" +
                "      \"accountNumber\": 748757732,\n" +
                "      \"accountType\": \"PAYMENT\",\n" +
                "      \"alias\": \"\",\n" +
                "      \"isVisible\": false,\n" +
                "      \"iban\": \"NL88INGB0748757732\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"accountBalanceInCents\": 15000,\n" +
                "      \"accountCurrency\": \"EUR\",\n" +
                "      \"accountId\": 700000027559,\n" +
                "      \"accountName\": \"\",\n" +
                "      \"accountNumber\": \"H 177-27066\",\n" +
                "      \"accountType\": \"SAVING\",\n" +
                "      \"alias\": \"G\\\\UfffdLSAVINGSdiacrits\",\n" +
                "      \"iban\": \"\",\n" +
                "      \"isVisible\": true,\n" +
                "      \"linkedAccountId\": 748757694,\n" +
                "      \"productName\": \"Oranje Spaarrekening\",\n" +
                "      \"productType\": 1000,\n" +
                "      \"savingsTargetReached\": 1,\n" +
                "      \"targetAmountInCents\": 2000\n" +
                "    }\n" +
                "  ],\n" +
                "  \"failedAccountTypes\" : \"CREDITCARDS\",\n" +
                "  \"returnCode\" : \"OK\"\n" +
                "}"
        var accountList = Gson().fromJson(jsonString, AccountList::class.java)
        return accountList
    }


}