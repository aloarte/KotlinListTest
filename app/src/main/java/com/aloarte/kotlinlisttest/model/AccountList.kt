package com.aloarte.kotlinlisttest.model

data class AccountList(

    var accounts: ArrayList<Account>? = null,

    var failedAccountTypes: String? = null,

    var returnCode: String? = null

)