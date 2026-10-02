class Solution {
    fun maxProfit(prices: IntArray): Int {

        val memo = Array(prices.size) { IntArray(3) }

        fun calculate(i: Int, stockState: Int): Int {
            if (i == prices.size) {
                return 0
            }

            if (memo[i][stockState] == 0) {
                var doNothing = 0
                var doSomething = 0
                if (stockState == 1) {
                    doSomething = prices[i] + calculate(i + 1, 2)
                    doNothing = calculate(i + 1, stockState)
                } else if (stockState == 0) {
                    doSomething = -prices[i] + calculate(i + 1, 1)
                    doNothing = calculate(i + 1, stockState)
                } else {
                    doNothing = calculate(i + 1, 0)
                }
                memo[i][stockState] = maxOf(doNothing, doSomething)
            }

            return memo[i][stockState]
        }

        return calculate(0, 0)
    }
}
