package com.zerobase.kafka.dto

data class LoanRequestDto (
    val userKey: String
    , val userName: String
    , val userRegistrationNumber: String
    , val userIncomeAmount: Long
)