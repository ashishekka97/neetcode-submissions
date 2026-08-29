import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        var prev1 = 0
        var prev2 = 0

        for (i in 2..n) {
            val cost1 = prev1 + cost[i - 1]
            val cost2 = prev2 + cost[i - 2]
            
            val currentCost = min(cost1, cost2) 
            
            prev2 = prev1
            prev1 = currentCost
        }

        return prev1
    }
}