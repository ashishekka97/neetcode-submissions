class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val output = mutableListOf<Int>()
        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })

        for (i in nums.indices) {
            heap.add(Pair(nums[i], i))
            if (i >= k - 1) {
                while (heap.peek().second <= i - k) {
                    heap.poll()
                }
                output.add(heap.peek().first)
            }
        }

        return output.toIntArray()
    }
}
