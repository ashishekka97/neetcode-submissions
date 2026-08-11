class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val adj = List<MutableList<Int>>(n) { mutableListOf() }

        for ((src, des) in edges) {
            adj[src].add(des)
            adj[des].add(src)
        }

        val visited = mutableSetOf<Int>()

        fun hasCycle(node: Int, parent: Int): Boolean {
            if (node in visited) return true

            visited.add(node)
            for (neighbor in adj[node]) {
                if (neighbor == parent) continue
                if (hasCycle(neighbor, node)) return true
            }
            return false
        }

        return !hasCycle(0, -1) && visited.size == n
    }
}
