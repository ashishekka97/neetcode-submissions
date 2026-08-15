class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for ((u, v, t) in times) {
            adj.getOrPut(u) { mutableListOf() }.add(Pair(t, v))
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>(
            compareBy { it.first }
        )

        val visited = mutableSetOf<Int>()

        var minTime = 0
        minHeap.offer(Pair(0, k))

        while (minHeap.isNotEmpty()) {
            val (time, node) = minHeap.poll()

            if (node in visited) continue

            visited.add(node)
            minTime = maxOf(minTime, time)

            val neighbors = adj.getOrDefault(node, mutableListOf())
            for ((newTime, newNode) in neighbors) {
                if (newNode !in visited) {
                    minHeap.offer(Pair(newTime + time, newNode))
                }
            }
        }

        if (visited.size == n) return minTime
        return -1
    }
}
