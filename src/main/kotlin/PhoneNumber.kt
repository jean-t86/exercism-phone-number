class PhoneNumber(numberStr: String) {

    // Filter to only have integers left
    private var numList: MutableList<Int> = numberStr
        .filter {
            it.toString().toIntOrNull() in 0..9
        }.map {
            it.toString().toInt()
        }.toMutableList()

    init {
        if (numList.size < 10 || numList.size > 11) {
            throw IllegalArgumentException()
        }

        // Remove international code
        if (numList.size == 11) {
            if (numList[0] == 1) {
                numList.removeAt(0)
            } else if (numList[0] != 1) {
                throw IllegalArgumentException()
            }
        }

        // Check 1st digit of area code and 1st digit of exchange code both starts with a number
        // between 2 and 9 inclusive
        if (numList[0] !in 2..9 || numList[3] !in 2..9) {
            throw IllegalArgumentException()
        }
    }

    val number: String = numList.joinToString("")
}
