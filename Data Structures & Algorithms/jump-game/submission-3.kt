class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size

        if (n == 1) return true

        fun calculate(goal: Int, index: Int): Boolean {
            if (index == 0) {
                return nums[index] >= goal
            }
            if (index < 0) return false

            if (index + nums[index] >= goal) {
                return calculate(index, index - 1)
            } else {
                return calculate(goal, index - 1)
            }
        }

        return calculate(n - 1, n - 2)
    }
}
