class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val complements = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            if (complements.contains(num)) {
                return intArrayOf(complements[num]!!, index)
            }
            complements[target - num] = index
        }

        return intArrayOf(0, 0)
    }
}
