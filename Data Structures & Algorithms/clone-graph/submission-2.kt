/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val oldToNewMap = mutableMapOf<Node?, Node?>()

        fun dfs(node: Node?): Node? {

            if (node == null) return null

            if (oldToNewMap.contains(node)) {
                return oldToNewMap[node]
            }

            val nodeToCopy = Node(node.`val`)
            oldToNewMap[node] = nodeToCopy
            for (neighbor in node.neighbors) {
                nodeToCopy.neighbors.add(dfs(neighbor))
            }

            return nodeToCopy
        }

        return dfs(node)
    }
}
