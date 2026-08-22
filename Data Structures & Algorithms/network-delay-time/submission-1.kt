class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for ((u, v, t) in times) {
            adj.getOrPut(u) { mutableListOf() }.add(Pair(v, t))
        }

        val distance = IntArray(n + 1) { Int.MAX_VALUE }.apply {
            this[0] = -1
            this[k] = 0
        }
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        queue.offer(Pair(k, 0))

        while (queue.isNotEmpty()) {
            val (u, d) = queue.poll()

            if (d > distance[u]) continue

            val neighbors = adj[u] ?: emptyList()
            for ((v, weight) in neighbors) {
                val newDistance = d + weight
                if (newDistance < distance[v]) {
                    distance[v] = newDistance
                    queue.offer(Pair(v, newDistance))
                }
            }
        }

        val maxDist = distance.maxOrNull() ?: Int.MAX_VALUE
        return if (maxDist == Int.MAX_VALUE) -1 else maxDist
    }
}
