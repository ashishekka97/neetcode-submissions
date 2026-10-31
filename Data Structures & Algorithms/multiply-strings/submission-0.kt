class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"

        val n1 = num1.reversed()
        val n2 = num2.reversed()

        var result = IntArray(n1.length + n2.length)

        for (i in n1.indices) {
            for (j in n2.indices) {
                val digit1 = n1[i].digitToInt()
                val digit2 = n2[j].digitToInt()

                var prod = digit1 * digit2
                result[i + j] += prod
                result[i + j + 1] += result[i + j] / 10
                result[i + j] = result[i + j] % 10
            }
        }

        result.reverse()
        var begin = 0
        while (begin < result.size && result[begin] == 0) {
            begin++
        }

        result = result.sliceArray(begin until result.size)
        return result.joinToString("")
    }
}
