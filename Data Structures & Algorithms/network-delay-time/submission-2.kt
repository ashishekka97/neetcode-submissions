class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }

        for ((u, v, t) in times) {
            graph[u].add(Pair(v, t))
        }

        val time = IntArray(n + 1) { Int.MAX_VALUE }.apply {
            this[0] = -1
            this[k] = 0
        }

        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        queue.offer(Pair(k, 0))

        while (queue.isNotEmpty()) {
            val (u, t) = queue.poll()

            if (t > time[u]) continue

            for ((v, w) in graph[u]) {
                val newTime = t + w
                if (newTime < time[v]) {
                    time[v] = newTime
                    queue.offer(Pair(v, newTime))
                }
            }
        }

        val maxTime = time.max()
        if (maxTime == Int.MAX_VALUE) return -1
        return maxTime
    }
}
