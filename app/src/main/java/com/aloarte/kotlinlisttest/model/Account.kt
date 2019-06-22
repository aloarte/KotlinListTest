package com.aloarte.kotlinlisttest.model

data class Account(

    var accountBalanceInCents: Long? = null,

    var accountCurrency: String? = null,

    var accountId: Long? = null,

    var accountName: String? = null,

    var accountNumber: String? = null,

    var accountType: String? = null,

    var alias: String? = null,

    var isVisible: Boolean? = null,

    var iban: String? = null,

    var linkedAccountId: Int? = null,

    var productName: String? = null,

    var productType: Int? = null,

    var savingsTargetReached: Int? = null,

    var targetAmountInCents: Long? = null
)