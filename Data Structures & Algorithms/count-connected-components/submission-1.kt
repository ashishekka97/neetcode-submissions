class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }

        fun find(node: Int): Int {
            var root = node
            while (root != parent[root]) {
                parent[root] = parent[parent[root]]
                root = parent[root]
            }

            return root
        }

        fun union(node1: Int, node2: Int): Int {
            val root1 = find(node1)
            val root2 = find(node2)

            if (root1 == root2) return 0

            if (size[root1] < size[root2]) {
                parent[root1] = root2
                size[root2] += size[root1]
            } else {
                parent[root2] = root1
                size[root1] += size[root2]
            }

            return 1
        }

        var result = n
        for ((src, dst) in edges) {
            result -= union(src, dst)
        }

        return result
    }
}
