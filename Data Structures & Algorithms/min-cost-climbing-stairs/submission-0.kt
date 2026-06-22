class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev1 = cost[1]
        var prev2 = cost[0]

        for (i in 2 until cost.size) {
            val curr = cost[i] + minOf(prev1, prev2)
            prev2 = prev1
            prev1 = curr
        }

        return minOf(prev1, prev2)
    }
}
