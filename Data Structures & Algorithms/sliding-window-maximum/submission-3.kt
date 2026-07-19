class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        // Monotonically decreasing deque (contains indices for th num)
        val deque = ArrayDeque<Int>()
        var start = 0

        val result = mutableListOf<Int>()

        for (end in nums.indices) {
            while (deque.isNotEmpty() && nums[deque.last()] < nums[end]) {
                deque.removeLast()
            }
            deque.addLast(end)

            if (start > deque.first()) {
                deque.removeFirst()
            }

            if (end - start + 1 >= k) {
                result.add(nums[deque.first()])
                start++
            }
        }

        return result.toIntArray()
    }
}
