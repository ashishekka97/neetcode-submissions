class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<Point>(compareByDescending {
            (it.x * it.x) + (it.y * it.y) }
        )

        for ((x, y) in points) {
            maxHeap.offer(Point(x, y))

            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        val result = mutableListOf<IntArray>()

        while (maxHeap.isNotEmpty()) {
            val point = maxHeap.poll()
            result.add(intArrayOf(point.x, point.y))
        }

        return result.toTypedArray()
    }

    data class Point(
        val x: Int,
        val y: Int
    )
}
