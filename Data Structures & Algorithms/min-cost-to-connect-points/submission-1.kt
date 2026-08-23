class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val graph = Array<MutableList<Pair<Int, Int>>>(n) { mutableListOf() }

        for (i in 0 until points.size) {
            for (j in i + 1 until points.size) {
                val (x1, y1) = points[i]
                val (x2, y2) = points[j]

                val distance = abs(x2 - x1) + abs(y2 - y1)
                graph[i].add(Pair(j, distance))
                graph[j].add(Pair(i, distance))
            }
        }

        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        queue.offer(Pair(0, 0))
        val visited = mutableSetOf<Int>()
        var result = 0
        while (visited.size < n) {
            val (u, d) = queue.poll()

            if (u in visited) continue

            result += d
            visited.add(u)

            val neighbors = graph[u] ?: continue
            for ((v, d) in neighbors) {
                if (v !in visited) {
                    queue.offer(Pair(v, d))
                }
            }
        }

        return result

    }
}
