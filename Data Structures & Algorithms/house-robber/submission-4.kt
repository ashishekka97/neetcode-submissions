class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        if (nums.size == 1) return nums[0]

        var oldLoot = 0
        var recentLoot = nums[0]

        for (i in 1 until nums.size) {
            val currentLoot = maxOf(recentLoot, oldLoot + nums[i])
            oldLoot = recentLoot
            recentLoot = currentLoot
        }

        return recentLoot
    }
}
