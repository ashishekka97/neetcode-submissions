class MedianFinder {

    val lowerMaxHeap = PriorityQueue<Int>(reverseOrder())
    val upperMinHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        lowerMaxHeap.offer(num)

        upperMinHeap.offer(lowerMaxHeap.poll())

        if (lowerMaxHeap.size < upperMinHeap.size) {
            lowerMaxHeap.offer(upperMinHeap.poll())
        }
    }

    fun findMedian(): Double {
        if (lowerMaxHeap.size > upperMinHeap.size) {
            return lowerMaxHeap.peek().toDouble()
        }

        return (lowerMaxHeap.peek() + upperMinHeap.peek()) / 2.0
    }
}
