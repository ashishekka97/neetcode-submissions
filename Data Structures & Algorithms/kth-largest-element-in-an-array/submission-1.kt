class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()

        for (num in nums) {
            minHeap.offer(num)

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.peek()
    }
}
