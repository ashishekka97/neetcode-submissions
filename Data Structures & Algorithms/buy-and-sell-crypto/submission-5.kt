class Solution {
    fun maxProfit(prices: IntArray): Int {
        var start = 0
        var maxProfit = 0

        for (end in 0 until prices.size) {
            if (prices[end] < prices[start]) {
                start = end
            } else {
                maxProfit = maxOf(maxProfit, prices[end] - prices[start])
            }
        }

        return maxProfit
    }
}
