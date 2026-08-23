class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var prices = IntArray(n) { Int.MAX_VALUE }
        prices[src] = 0

        for (i in 0..k) {
            val tempPrices = prices.clone()
            for ((u, v, p) in flights) {
                if (prices[u] != Int.MAX_VALUE && prices[u] + p < tempPrices[v]) {
                    tempPrices[v] = prices[u] + p
                }
            }
            prices = tempPrices
        }

        if (prices[dst] == Int.MAX_VALUE) return -1
        return prices[dst]
    }
}
