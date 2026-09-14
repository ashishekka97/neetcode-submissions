class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (coin in coins) {
            for (a in coin..amount) {
                dp[a] = minOf(dp[a], 1 + dp[a - coin])
            }
        }

        if (dp[amount] == amount + 1) return -1
        return dp[amount]
    }
}
