/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {

        fun dfs(root: TreeNode?): Pair<Boolean, Int> {
            if (root == null) return Pair(true, 0)

            val left = dfs(root.left)
            val right = dfs(root.right)
            val balanced = left.first && right.first && abs(left.second - right.second) <= 1
            val height = 1 + maxOf(left.second, right.second)

            return Pair(balanced, height)
        }

        return dfs(root).first
    }
}
