fun main() {

    var commission = 0.0
    val monthTransactionsAmount = 100_000.00
    val transactionAmount = readln().toDouble()
    val paymentSystemType = "Visa"

    fun visaCommissionCount(transactionAmount: Double, minCommission: Double = 35.00): Double {

        commission = transactionAmount * 0.075
        if (commission < 35.00) {
            commission = minCommission
        }
        return commission
    }

    fun mastercardCommissionCount(transactionAmount: Double, noCommissionLimit: Double = 75_000.0): Double {

        if (monthTransactionsAmount > noCommissionLimit) {
            commission = transactionAmount * 0.06 + 20
        }
        commission = if ((monthTransactionsAmount + transactionAmount > noCommissionLimit) && (monthTransactionsAmount < noCommissionLimit)) {
            (monthTransactionsAmount + transactionAmount - 75_000) * 0.06 + 20
        } else 0.0

        return commission
    }

    fun commissionCount(paymentSystemType: String, monthTransactionsAmount: Double, transactionAmount: Double): Double {

        if ((transactionAmount <= 150_000.00) && ((monthTransactionsAmount + transactionAmount) <= 600_000)) {
            when (paymentSystemType) {
                "Visa" -> commission = visaCommissionCount(transactionAmount)
                "Mastercard" -> commission = mastercardCommissionCount(transactionAmount)
                "Мир" -> commission = 0.0
            }
            println(commission)
        } else {
            commission = 0.0
            println("Операция заблокирована")
        }

        return commission
    }
    commissionCount(paymentSystemType, monthTransactionsAmount, transactionAmount)
}



