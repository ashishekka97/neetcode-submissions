class Solution {
    fun isHappy(n: Int): Boolean {
        val visited = HashSet<Int>()

        var num = n
        while (num !in visited) {
            visited.add(num)
            num = sumOfSquares(num)
            if (num == 1) return true
        }

        return false
    }

    fun sumOfSquares(n: Int): Int {
        var output = 0
        var num = n
        while (num > 0) {
            val digit = num % 10
            output += digit * digit
            num /= 10
        }

        return output
    }
}
