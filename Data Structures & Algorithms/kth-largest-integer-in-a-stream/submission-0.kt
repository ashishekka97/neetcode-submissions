class KthLargest(k: Int, nums: IntArray) {

    private val k = k
    private val minHeap = PriorityQueue<Int>()

    init {
        for (num in nums) {
            minHeap.offer(num)
        }

        while (minHeap.size > k) {
            minHeap.poll()
        }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }

        return minHeap.peek()
    }
}
