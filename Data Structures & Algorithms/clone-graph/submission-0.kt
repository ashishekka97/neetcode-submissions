/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val oldToNew = mutableMapOf<Node?, Node?>()

        fun dfs(node: Node?): Node? {
            if (node == null) return null
            
            if (oldToNew.containsKey(node)) {
                return oldToNew[node]
            }

            
            val copyNode = Node(node.`val`)
            oldToNew[node] = copyNode
            for (neighbor in node.neighbors) {
                copyNode.neighbors.add(dfs(neighbor))
            }

            return copyNode
        }

        return dfs(node)
    }
}
