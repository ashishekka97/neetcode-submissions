class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }
        val rank = IntArray(edges.size + 1) { 1 }

        fun find(node: Int): Int {
            var p = node
            while (p != parent[p]) {
                parent[p] = parent[parent[p]]
                p = parent[p]
            }

            return p
        }

        fun union(u: Int, v: Int): Boolean {
            val p1 = find(u)
            val p2 = find(v)

            if (p1 == p2) return false
            
            if (rank[p2] > rank[p1]) {
                parent[p1] = p2
                rank[p2] += rank[p1]
            } else {
                parent[p2] = p1
                rank[p1] += rank[p2]
            }

            return true
        }

        for ((u, v) in edges) {
            if (!union(u, v)) return intArrayOf(u, v)
        }

        return intArrayOf()
    }
}
