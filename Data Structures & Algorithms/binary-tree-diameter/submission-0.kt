/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var res = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            res = maxOf(res, left + right)

            return 1 + maxOf(left, right)
        }

        dfs(root)
        return res
    }
}
