class Solution {
    fun lastStoneWeight(stones: IntArray): Int {

        val heap = PriorityQueue<Int>(reverseOrder())

        for (stone in stones) {
            heap.offer(stone)
        }

        while (heap.size > 1) {
            val x = heap.poll()
            val y = heap.poll()

            heap.offer(x - y)
        }
        
        return Math.abs(heap.peek())
    }
}
