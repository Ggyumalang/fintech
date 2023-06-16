package com.zerobase.consumer.dto

import com.zerobase.domain.domain.LoanReview

data class ReviewResponseDto (
        val userKey: String
        , val userLimitAmount: Long
        , val userLoanInterest: Double
) {
    fun toLoanReviewEntity() : LoanReview =
            LoanReview (
                    userKey = this.userKey
                    , loanLimitedAmount = this.userLimitAmount
                    , loanInterest = this.userLoanInterest
            )
}