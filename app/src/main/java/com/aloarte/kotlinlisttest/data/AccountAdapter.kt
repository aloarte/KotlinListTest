package com.aloarte.kotlinlisttest.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.aloarte.kotlinlisttest.R
import com.aloarte.kotlinlisttest.model.Account
import kotlinx.android.synthetic.main.list_item_account.view.*

class AccountAdapter(private val context : Context, private val dataSource: ArrayList<Account>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /**
     * Number of items to display
     */
    override fun getCount(): Int {
        return dataSource.size
    }

    /**
     * Return the itemt in the given position
     */
    override fun getItem(position: Int): Account {
        return dataSource[position]
    }

    /**
     * Id of each item on the list
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    /**
     * Build the custom view for the AccountAdapter
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_account, parent, false)
        val account = getItem(position)

        rowView.tv_account_name.text = account.accountName
        rowView.tv_account_iban.text = account.iban
        rowView.tv_account_type.text = account.accountType
        rowView.tv_account_balance.text =account.accountBalanceInCents.toString()
        rowView.tv_account_currency.text =account.accountCurrency.toString()
        return rowView


    }

}