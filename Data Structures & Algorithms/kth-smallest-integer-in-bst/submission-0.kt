/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var result = -1
        var count = 0

        fun dfs(root: TreeNode?) {
            if (root == null || count >= k) return

            dfs(root.left)

            count++
            if (k == count) {
                result = root.`val`
                return
            }

            dfs(root.right)
        }

        dfs(root)
        return result
    }
}
