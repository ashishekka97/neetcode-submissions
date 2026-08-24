class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        
        return maxOf(
            rob2(nums.copyOf(nums.size - 1)),
            rob2(nums.copyOfRange(1, nums.size))
        )
    }

    fun rob2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        var prev2 = 0
        var prev1 = nums[0]

        for (i in 1 until nums.size) {
            val curr = maxOf(nums[i] + prev2, prev1)
            prev2 = prev1
            prev1 = curr
        }

        return prev1
    }
}
