class Solution {
    fun rob(nums: IntArray): Int {
        var recentLoot = 0
        var olderLoot = 0

        for (i in 0 until nums.size) {
            val currentLoot = maxOf(nums[i] + olderLoot, recentLoot)
            olderLoot = recentLoot
            recentLoot = currentLoot
        }

        return maxOf(olderLoot, recentLoot)
    }
}
