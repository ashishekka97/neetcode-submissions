class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val n = coins.size
        val dp = Array(coins.size + 1) { IntArray(amount + 1) }

        for (i in 0..n) {
            dp[i][0] = 1
        }

        for (i in 1..amount) {
            dp[n][amount] = 0
        }

        for (i in (n - 1) downTo 0) {
            for (j in 1..amount) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i + 1][j]
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]]
                }
            }
        }

        return dp[0][amount]
    }
}
