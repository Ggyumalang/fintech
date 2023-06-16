package com.zerobase.css.dto

class LoanResultDto {
    data class ResponseDto (
            val userKey: String
            , val userLimitAmount: Long
            , val userLoanInterest: Double
    )
}