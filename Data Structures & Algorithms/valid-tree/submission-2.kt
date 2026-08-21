class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false

        val parent = IntArray(n) { it }
        val rank = IntArray(n) { 1 }

        fun find(node: Int): Int {
            var current = node
            while (current != parent[current]) {
                parent[current] = parent[parent[current]]
                current = parent[current]
            }
            return current
        }

        fun union(node1: Int, node2: Int): Boolean {
            val root1 = find(node1)
            val root2 = find(node2)

            if (root1 == root2) return false

            if (rank[root1] < rank[root2]) {
                parent[root1] = root2
                rank[root2] += rank[root1]
            } else if (rank[root1] >= rank[root2]) {
                parent[root2] = root1
                rank[root1] += rank[root2]
            }

            return true
        }

        for ((src, dst) in edges) {
            if (!union(src, dst)) return false
        }

        return true
    }
}
