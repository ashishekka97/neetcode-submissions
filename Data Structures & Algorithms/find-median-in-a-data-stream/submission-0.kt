class MedianFinder {

    val minHeap: PriorityQueue<Int>
    val maxHeap: PriorityQueue<Int>

    init {
        minHeap = PriorityQueue<Int>()
        maxHeap = PriorityQueue<Int>(reverseOrder())
    }

    fun addNum(num: Int) {
        maxHeap.offer(num)

        if (maxHeap.isNotEmpty() && minHeap.isNotEmpty() && maxHeap.peek() >  minHeap.peek()) {
            minHeap.offer(maxHeap.poll())
        }

        if (maxHeap.size - 1 > minHeap.size) {
            minHeap.offer(maxHeap.poll())
        }
        if (minHeap.size - 1 > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        if (maxHeap.size > minHeap.size) {
            return maxHeap.peek().toDouble()
        }

        if (minHeap.size > maxHeap.size) {
            return minHeap.peek().toDouble()
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0
    }
}
