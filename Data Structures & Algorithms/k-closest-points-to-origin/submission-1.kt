class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue(compareBy<IntArray> { it[0] * it[0] + it[1] * it[1] })

        for (point in points) {
            minHeap.offer(point)
        }

        val result = mutableListOf<IntArray>()
        repeat(k) {
            result.add(minHeap.poll())
        }

        return result.toTypedArray()
    }
}
