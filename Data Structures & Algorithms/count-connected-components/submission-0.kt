class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {

        val parent = IntArray(n) { it }
        val rank = IntArray(n) { 1 }

        fun find(node: Int): Int {
            var root = node

            while (root != parent[root]) {
                // Path Compression
                parent[root] = parent[parent[root]]
                root = parent[root]
            }
            return root
        }

        fun union(node1: Int, node2: Int): Int {
            val parent1 = find(node1)
            val parent2 = find(node2)

            if (parent1 == parent2) return 0

            if (rank[parent2] > rank[parent1]) {
                parent[parent1] = parent2
                rank[parent2] += rank[parent1]
            } else {
                parent[parent2] = parent1
                rank[parent1] += rank[parent2]
            }

            return 1
        }

        var result = n
        for ((u, v) in edges) {
            result -= union(u, v)
        }
        return result
    }
}
