class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val memo = mutableMapOf<String, Int>()
        fun calculate(i: Int, goal: Int): Int {
            if (i == nums.size) {
                if (goal == target) return 1
                return 0
            }

            val key = "$i-$goal"

            if (memo.containsKey(key)) return memo[key]!!

            memo[key] = calculate(i + 1, goal + nums[i]) + calculate(i + 1, goal - nums[i])
            return memo[key]!!
        }

        return calculate(0, 0)
    }
}
