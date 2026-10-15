class Solution {
    fun maxCoins(nums: IntArray): Int {
        val newNums = intArrayOf(1) + nums + intArrayOf(1)
        val n = newNums.size
        val memo = Array(n) { IntArray(n) }

        fun calculate(l: Int, r: Int): Int {
            if (l > r) return 0

            if (memo[l][r] > 0) return memo[l][r]

            memo[l][r] = 0
            for (i in l..r) {
                val coins = newNums[l - 1] * newNums[i] * newNums[r + 1]
                val totalCoins = coins + calculate(l, i - 1) + calculate(i + 1, r)
                memo[l][r] = maxOf(memo[l][r], totalCoins)
            }

            return memo[l][r]
        }

        return calculate(1, n - 2)
    }
}
