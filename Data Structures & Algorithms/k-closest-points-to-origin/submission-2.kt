class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue(compareBy<IntArray> { -(it[0] * it[0] + it[1] * it[1]) })

        for (point in points) {
            maxHeap.offer(point)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        val result = mutableListOf<IntArray>()
        while (maxHeap.isNotEmpty()) {
            result.add(maxHeap.poll())
        }

        return result.toTypedArray()
    }
}
