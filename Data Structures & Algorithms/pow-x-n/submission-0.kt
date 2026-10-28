class Solution {
    fun myPow(x: Double, n: Int): Double {
        fun helper(x: Double, n: Int): Double {
            if (x == 0.0) return 0.0
            if (n == 0) return 1.0

            var res = helper(x, n / 2)
            res = res * res
            if (n % 2 != 0) {
                return x * res
            } else {
                return res
            }
        }

        val res = helper(x, abs(n))
        return if (n >= 0.0) res else 1 / res
    }
}
