class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        var longest = 0
        for (num in nums) {
            if (num - 1 !in set) {
                var length = 0
                while (num + length in set) {
                    length += 1
                }
                longest = Math.max(longest, length)
            }
        }

        return longest
    }
}
