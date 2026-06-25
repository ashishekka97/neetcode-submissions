class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until nums.size) {
            val required = target - nums[i]
            if (map[required] != null) {
                return intArrayOf(map[required]!!, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }
}
