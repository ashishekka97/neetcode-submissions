class KthLargest(k: Int, nums: IntArray) {

    var k: Int
    val minHeap: PriorityQueue<Int>

    init {
        this.k = k
        minHeap = PriorityQueue<Int>()
        for (num in nums) {
            minHeap.offer(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
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
