class Solution {
    fun maxProfit(prices: IntArray): Int {
        val memo = Array(prices.size) { IntArray(2) { -1 } }

        fun solve(i: Int, buying: Boolean): Int {
            if (i >= prices.size) return 0

            val buyState = if (buying) 1 else 0

            if (memo[i][buyState] != -1) return memo[i][buyState]

            if (buying) {
                val buyToday = solve(i + 1, false) - prices[i]
                val skipToday = solve(i + 1, true)
                memo[i][buyState] = maxOf(buyToday, skipToday)
            } else {
                val sellToday = solve(i + 2, true) + prices[i]
                val skipToday = solve(i + 1, false)
                memo[i][buyState] = maxOf(sellToday, skipToday)
            }

            return memo[i][buyState]
        }

        return solve(0, true)
    }
}
