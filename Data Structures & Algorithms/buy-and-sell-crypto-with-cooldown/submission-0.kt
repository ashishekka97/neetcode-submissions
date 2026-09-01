class Solution {
    fun maxProfit(prices: IntArray): Int {
        // State is gonna be buying or selling
        // buy -> i + 1
        // sell -> i + 2

        val dp = mutableMapOf<State, Int>()

        fun dfs(state: State): Int {
            val (index, buying) = state

            if (index >= prices.size) return 0

            if (state in dp) return dp[state] ?: 0

            val cooldown = dfs(State(index + 1, buying))
            if (buying) {
                val buy = dfs(State(index + 1, !buying)) - prices[index]
                dp[state] = maxOf(buy, cooldown)
            } else {
                val sell = dfs(State(index + 2, !buying)) + prices[index]
                dp[state] = maxOf(sell, cooldown)
            }

            return dp[state] ?: 0
        }

        return dfs(State(0, true))
    }

    data class State(val index: Int, val buying: Boolean)
}
