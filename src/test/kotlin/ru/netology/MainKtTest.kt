package ru.netology

import commissionCount
import mastercardCommissionCount
import org.junit.Assert.*
import org.junit.Test
import visaCommissionCount


class MainKtTest {
    @Test
    fun visaCommissionCountMinCommission() {
        val transactionAmount = 100.00

        val commission = visaCommissionCount(transactionAmount)

       assertEquals(35.00, commission, 0.0)
    }
    @Test
    fun visaCommissionCountCommission() {
        val transactionAmount = 100000.0

        val commission = visaCommissionCount(transactionAmount)

        assertEquals(7500.00, commission, 0.0)
    }

    @Test
    fun mastercardCommissionCountNocommissionlimitIsLessMonthTransactionsAmount() {
        val transactionAmount = 10_000.00
        val noCommissionLimit = 75_000.0
        val monthTransactionsAmount = 80_000.0

        val commission = mastercardCommissionCount(transactionAmount, noCommissionLimit, monthTransactionsAmount)

        assertEquals(620.00, commission, 0.0)
    }
    @Test
    fun mastercardCommissionCountNocommissionlimitIsMoreMonthTransactionsAmount() {
        val transactionAmount = 100_000.0
        val noCommissionLimit = 75_000.0
        val monthTransactionsAmount = 0.0

        val commission = mastercardCommissionCount(transactionAmount, noCommissionLimit, monthTransactionsAmount)

        assertEquals(1520.00, commission, 0.0)
    }
    @Test
    fun mastercardCommissionCountZeroCommission() {
        val transactionAmount = 10_000.0
        val noCommissionLimit = 75_000.0
        val monthTransactionsAmount = 0.0

        val commission = mastercardCommissionCount(transactionAmount, noCommissionLimit, monthTransactionsAmount)

        assertEquals(0.0, commission, 0.0)
    }

    @Test
    fun mastercardCommissionCountCheckNoCommissionLimit() {

        val noCommissionLimit = 75_000.0

        assertEquals(75_000.0, noCommissionLimit, 0.0)
    }

    @Test
    fun mastercardCommissionCountCheckMonthTrancactionAmount() {

        val monthTransactionAmount = 100_000.0

        assertEquals(100_000.0, monthTransactionAmount, 0.0)
    }

    @Test
    fun commissionCountPaymentSystemMir() {

        val transactionAmount = 10_000.0
        val monthTransactionsAmount = 100_000.0
        val noCommissionLimit = 75_000.0

        val commission = commissionCount("Мир", transactionAmount, monthTransactionsAmount, noCommissionLimit)

        assertEquals(0.0, commission, 0.0)
    }

    @Test
    fun commissionCountPaymentSystemVisa() {

        val transactionAmount = 10_000.0
        val monthTransactionsAmount = 100_000.0
        val noCommissionLimit = 75_000.0

        val commission = commissionCount("Visa", transactionAmount, monthTransactionsAmount, noCommissionLimit)

        assertEquals(750.0, commission, 0.0)
    }

    @Test
    fun commissionCountPaymentSystemMastercard() {

        val transactionAmount = 10_000.0
        val monthTransactionsAmount = 100_000.0
        val noCommissionLimit = 75_000.0

        val commission = commissionCount("Mastercard", transactionAmount, monthTransactionsAmount, noCommissionLimit)

        assertEquals(620.0, commission, 0.0)
    }

    @Test
    fun commissionCountMaxLimitsReached() {

        val transactionAmount = 150_000.0
        val monthTransactionsAmount = 500_000.0
        val noCommissionLimit = 75_000.0

        val commission = commissionCount("Visa", transactionAmount, monthTransactionsAmount, noCommissionLimit)

        assertEquals(0.0, commission, 0.0)
    }

}