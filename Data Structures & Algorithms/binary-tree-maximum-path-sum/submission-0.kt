/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var globalMax = Int.MIN_VALUE

        // Return maximum without splitting
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            val leftMax = maxOf(dfs(root.left), 0)
            val rightMax = maxOf(dfs(root.right), 0)

            // Check if globalMax can up updated if we decide to split
            globalMax = maxOf(globalMax, root.`val` + leftMax + rightMax)

            return root.`val` + maxOf(leftMax, rightMax)
        }

        dfs(root)

        return globalMax
    }
}
