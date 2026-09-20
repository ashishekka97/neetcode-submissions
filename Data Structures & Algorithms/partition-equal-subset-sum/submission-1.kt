class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) return false

        val target = total / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true

        for (num in nums) {
            for (j in target downTo num) {
                dp[j] = dp[j] || dp[j - num]
            }
        }

        return dp[target]
    }
}
