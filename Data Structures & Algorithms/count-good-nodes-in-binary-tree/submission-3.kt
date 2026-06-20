/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        fun dfs(root: TreeNode?, maxSoFar: Int): Int {
            if (root == null) return 0

            val isGood = if (root.`val` >= maxSoFar) 1 else 0

            val newMax = maxOf(maxSoFar, root.`val`)

            return isGood + dfs(root.left, newMax) + dfs(root.right, newMax)
        }

        return dfs(root, Int.MIN_VALUE)
    }
}
