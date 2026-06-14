class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1

        while (lo <= hi) {
            val mid = (hi - lo) + 1 / 2

            when {
                nums[mid] < target -> lo++
                nums[mid] > target -> hi--
                else -> return mid
            }
        }

        return -1
    }
}
