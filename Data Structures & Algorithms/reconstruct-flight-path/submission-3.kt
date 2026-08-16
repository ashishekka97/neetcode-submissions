class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = mutableMapOf<String, PriorityQueue<String>>()


        for ((src, dst) in tickets) {
            adj.getOrPut(src) { PriorityQueue() }.add(dst)
        }
        
        val result = mutableListOf<String>()

        fun dfs(src: String) {
            val destinations = adj[src]

            while (destinations != null && destinations.isNotEmpty()) {
                val nextDst = destinations.poll()
                dfs(nextDst)
            }
            result.add(src)
        }

        dfs("JFK")
        return result.reversed()
    }
}
