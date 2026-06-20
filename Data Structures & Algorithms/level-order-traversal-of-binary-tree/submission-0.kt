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

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val qSize = q.size
            val level = mutableListOf<Int>()
            
            for (i in 0 until qSize) {
                val node = q.removeFirst()
                level.add(node.`val`)
                
                if (node.left != null) q.add(node.left)

                if (node.right != null) q.add(node.right)
            }
            if (level.isNotEmpty()) {
                result.add(level)
            }
        }

        return result
    }
}
