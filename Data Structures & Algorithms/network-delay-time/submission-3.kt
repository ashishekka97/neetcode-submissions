class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array<MutableList<IntArray>>(n + 1) { mutableListOf() }

        for ((u, v, t) in times) {
            graph[u].add(intArrayOf(v, t))
        }

        val time = IntArray(n + 1) { Int.MAX_VALUE }.apply {
            this[0] = -1
            this[k] = 0
        }

        val queue = PriorityQueue<IntArray>(compareBy { it[1] })
        queue.offer(intArrayOf(k, 0))

        while (queue.isNotEmpty()) {
            val (u, t) = queue.poll()

            if (t > time[u]) continue

            for ((v, w) in graph[u]) {
                val newTime = t + w
                if (newTime < time[v]) {
                    time[v] = newTime
                    queue.offer(intArrayOf(v, newTime))
                }
            }
        }

        val maxTime = time.max()
        if (maxTime == Int.MAX_VALUE) return -1
        return maxTime
    }
}
