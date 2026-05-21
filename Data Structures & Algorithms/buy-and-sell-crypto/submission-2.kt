class Solution {
    fun maxProfit(prices: IntArray): Int {
        var start = 0
        var end = 1
        var maxProfit = 0

        while (end < prices.size) {
            if (prices[start] < prices[end]) {
                val profit = prices[end] - prices[start]
                maxProfit = maxOf(profit, maxProfit)
            } else {
                start = end
            }
            end += 1
        }

        return maxProfit
    }
}
