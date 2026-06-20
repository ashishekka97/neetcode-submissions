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

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val qSize = q.size

            result.add(q.last().`val`)
            for (i in 0 until qSize) {
                val node = q.removeFirst()

                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
        }

        return result
    }
}
