class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val prices = IntArray(n) { Int.MAX_VALUE }
        prices[src] = 0

        for (i in 0..k) {
            val tempPrices = prices.copyOf()
            for ((u, v, p) in flights) {
                if (prices[u] == Int.MAX_VALUE) continue

                if (prices[u] + p < tempPrices[v]) {
                    tempPrices[v] = prices[u] + p
                }
            }
            tempPrices.copyInto(prices)
        }

        if (prices[dst] == Int.MAX_VALUE) return -1
        return prices[dst]
    }
}
