class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val adj = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for (i in 0 until n) {
            val (x1, y1) = points[i]
            for (j in i + 1 until n) {
                val (x2, y2) = points[j]
                val dist = abs(x2 - x1) + abs(y2 - y1)
                adj.getOrPut(i) { mutableListOf() }.add(Pair(dist, j))
                adj.getOrPut(j) { mutableListOf() }.add(Pair(dist, i))
            }
        }

        var result = 0
        val visited = mutableSetOf<Int>()
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        minHeap.offer(Pair(0, 0))

        while (visited.size < n) {
            val (cost, i) = minHeap.poll()

            if (i in visited) continue

            result += cost
            visited.add(i)

            val neighbors = adj[i] ?: continue

            for (neighbor in neighbors) {
                val (neighCost, neighI) = neighbor
                if (neighI !in visited) {
                    minHeap.offer(Pair(neighCost, neighI))
                }
            }
        }

        return result
    }
}
