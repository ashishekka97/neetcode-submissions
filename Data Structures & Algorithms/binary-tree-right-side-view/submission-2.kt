/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            result.add(queue.last().`val`)

            for (i in 0 until queue.size) {
                val node = queue.removeFirst()

                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }

        return result
    }
}
