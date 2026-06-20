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

        var q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val qSize = q.size
            val level = mutableListOf<Int>()

            for (i in 0 until qSize) {
                val node = q.removeFirst()
                level.add(node.`val`)

                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
            result.add(level)
        }

        return result
    }
}
