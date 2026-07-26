/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level = mutableListOf<Int>()

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
                level.add(node.`val`)
            }

            result.add(level)
        }

        return result
    }
}
