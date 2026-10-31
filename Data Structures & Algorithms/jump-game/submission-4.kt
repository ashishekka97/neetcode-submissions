class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        var goal = n - 1

        for (i in n - 1 downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }

        return goal == 0
    }
}
