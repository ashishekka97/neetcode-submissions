class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var fast = nums[nums[0]]
        var slow = nums[0]

        while (fast != slow) {
            fast = nums[nums[fast]]
            slow = nums[slow]
        }

        fast = 0
        while (fast != slow) {
            fast = nums[fast]
            slow = nums[slow]
        }

        return slow
    }
}
