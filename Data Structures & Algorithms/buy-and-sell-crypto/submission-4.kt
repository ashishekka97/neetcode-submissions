class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var start = 0
        var maxProfit = 0

        for (end in 1 until prices.size) {
            if (prices[start] > prices[end]) {
                start = end
            } else {
                maxProfit = maxOf(maxProfit, prices[end] - prices[start])
            }
        }

        return maxProfit
    }
}
