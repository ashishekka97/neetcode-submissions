class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size

        if (n == 1) return nums[0]
        if (n < 3) return maxOf(nums[0], nums[1])

        var oldRob = 0
        var newRob = nums[0]

        for (i in 2..n) {
            val currentRob = maxOf(newRob, oldRob + nums[i - 1])
            oldRob = newRob
            newRob = currentRob
        }

        return newRob
    }
}
