class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1


        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] == target) return mid
            else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
        }

        return -1
    }
}
