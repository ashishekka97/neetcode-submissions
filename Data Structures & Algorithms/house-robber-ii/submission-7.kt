class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        fun houseRobber(start: Int, end: Int): Int {
            var oldLoot = 0
            var recentLoot = 0

            for (i in start until end) {
                val currLoot = maxOf(recentLoot, oldLoot + nums[i])
                oldLoot = recentLoot
                recentLoot = currLoot
            }

            return recentLoot
        }

        val loot1 = houseRobber(0, nums.size - 1)
        val loot2 = houseRobber(1, nums.size)

        return maxOf(loot1, loot2)
    }
}
