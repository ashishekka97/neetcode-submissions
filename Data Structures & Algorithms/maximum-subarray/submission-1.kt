class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var globalMax = nums[0]
        var currentSum = 0

        for (i in 0 until nums.size) {
            if (currentSum < 0) {
                currentSum = 0
            }
            currentSum += nums[i]
            globalMax = maxOf(globalMax, currentSum)
        }

        return globalMax
    }
}
