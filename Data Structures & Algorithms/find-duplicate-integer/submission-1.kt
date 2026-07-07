class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var fast = 0
        var slow = 0

        while (true) {
            fast = nums[nums[fast]]
            slow = nums[slow]
            if (slow == fast) break
        }

        fast = 0
        while (true) {
            fast = nums[fast]
            slow = nums[slow]
            if (slow == fast) break
        }

        return slow
    }
}
