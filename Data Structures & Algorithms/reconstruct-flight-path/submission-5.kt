class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val graph = mutableMapOf<String, PriorityQueue<String>>()

        for ((src, dst) in tickets) {
            graph.getOrPut(src) { PriorityQueue() }.offer(dst)
        }

        val result = ArrayDeque<String>()

        fun dfs(source: String) {
            val destinations = graph[source]

            while (destinations?.isNotEmpty() == true) {
                dfs(destinations.poll())
            }

            result.addFirst(source)
        }

        dfs("JFK")

        return result.toList()
    }
}
