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

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            val left = dfs(root.left)
            val right = dfs(root.right)

            res = maxOf(res, left + right)
            
            return 1 + maxOf(left, right)
        }

        dfs(root)
        return res
    }
}
