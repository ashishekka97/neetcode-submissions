class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = Array(coins.size) { IntArray(amount + 1) { -1 } }

        fun calculate(i: Int, a: Int): Int {
            if (a == 0) return 1

            if (i == coins.size) return 0

            if (memo[i][a] != -1) return memo[i][a]

            if (coins[i] > a) {
                memo[i][a] = calculate(i + 1, a)
            } else {
                memo[i][a] = calculate(i, a - coins[i]) + calculate(i + 1, a)
            }
            return memo[i][a]
        }

        return calculate(0, amount)
    }
}
