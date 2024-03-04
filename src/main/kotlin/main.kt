var commission = 0.0
fun main() {
    val transactionAmount = readln().toDouble()
    val paymentSystemType = "Mastercard"


    commissionCount(paymentSystemType, 100_000.0, transactionAmount)
}

fun visaCommissionCount(transactionAmount: Double, minCommission: Double = 35.00): Double {

    commission = transactionAmount * 0.075
    if (commission < minCommission) {
        commission = minCommission
    }
    return commission
}

fun mastercardCommissionCount(
    transactionAmount: Double,
    noCommissionLimit: Double = 75_000.0,
    monthTransactionsAmount: Double = 100_000.0
): Double {

    commission = if (monthTransactionsAmount > noCommissionLimit) {
        transactionAmount * 0.06 + 20
    } else if ((monthTransactionsAmount < noCommissionLimit) && ((monthTransactionsAmount + transactionAmount) > noCommissionLimit)) {
        (monthTransactionsAmount + transactionAmount - noCommissionLimit) * 0.06 + 20
    } else {
        0.0
    }

    return commission
}

fun commissionCount(
    paymentSystemType: String,
    transactionAmount: Double,
    monthTransactionsAmount: Double = 100_000.0,
    noCommissionLimit: Double = 75_000.0,
): Double {

    if ((transactionAmount <= 150_000.00) && ((monthTransactionsAmount + transactionAmount) <= 600_000)) {
        when (paymentSystemType) {
            "Visa" -> commission = visaCommissionCount(transactionAmount)
            "Mastercard" -> commission =
                mastercardCommissionCount(transactionAmount, noCommissionLimit, monthTransactionsAmount)

            "Мир" -> commission = 0.0
        }
        println(commission)
    } else {
        commission = 0.0
        println("Операция заблокирована")
    }

    return commission
}



