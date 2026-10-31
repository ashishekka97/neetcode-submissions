class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it[0] }

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val res = mutableMapOf<Int, Int>()
        var i = 0

        val sorted = queries.sortedArray()

        for (q in sorted) {
            while (i < intervals.size && intervals[i][0] <= q) {
                val start = intervals[i][0]
                val end = intervals[i][1]
                minHeap.offer(Pair(end - start + 1, end))
                i++
            }

            while (minHeap.isNotEmpty() && minHeap.peek().second < q) {
                minHeap.poll()
            }

            if (minHeap.isNotEmpty()) {
                res[q] = minHeap.peek().first
            } else {
                res[q] = -1
            }
        }

        return queries.map { res[it]!! }.toIntArray()
    }
}
