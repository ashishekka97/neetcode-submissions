class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var oldCost = 0
        var recentCost = 0

        for (c in cost) {
            val currCost = minOf(oldCost, recentCost) + c
            oldCost = recentCost
            recentCost = currCost
        }

        return minOf(oldCost, recentCost)
    }
}
