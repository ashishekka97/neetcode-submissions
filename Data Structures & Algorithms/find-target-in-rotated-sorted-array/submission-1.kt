class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (nums[mid] == target) return mid
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }

        return -1
    }
}
