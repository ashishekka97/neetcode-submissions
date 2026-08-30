class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val skippedFirst = rob(nums, 1, nums.size)
        val skippedLast = rob(nums, 0, nums.size - 1)
        return maxOf(skippedFirst, skippedLast)
    }

    fun rob(houses: IntArray, start: Int, end: Int): Int {
        var oldLoot = 0
        var newLoot = 0

        for (i in start until end) {
            val currentLoot = maxOf(newLoot, oldLoot + houses[i])
            oldLoot = newLoot
            newLoot = currentLoot
        }

        return newLoot
    }
}
