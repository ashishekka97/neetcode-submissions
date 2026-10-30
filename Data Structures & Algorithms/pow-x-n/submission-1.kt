class Solution {
    fun myPow(x: Double, n: Int): Double {
        fun calculate(x: Double, n: Int): Double {
            if (x == 0.0) return 0.0
            if (n == 0) return 1.0

            var res = calculate(x, n / 2)
            res *= res

            if (n % 2 != 0) {
                return x * res
            } else {
                return res
            }
        }

        val res = calculate(x, abs(n))

        if (n < 0) return 1 / res
        return res
    }
}
