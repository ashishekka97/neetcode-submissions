class Solution {
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1

        var min = nums[0]

        while (start <= end) {
            if (nums[start] < nums[end]) {
                min = minOf(min, nums[start])
                break
            }

            val mid = start + (end - start) / 2
            min = minOf(min, nums[mid])
            if (nums[start] <= nums[mid]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return min
    }
}
