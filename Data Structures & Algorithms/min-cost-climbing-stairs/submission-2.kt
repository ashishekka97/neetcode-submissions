class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev2 = cost[0]
        var prev1 = cost[1]

        for (i in 2 until cost.size) {
            val curr = minOf(prev2, prev1) + cost[i]
            prev2 = prev1
            prev1 = curr
        }

        return minOf(prev1, prev2)
    }
}
