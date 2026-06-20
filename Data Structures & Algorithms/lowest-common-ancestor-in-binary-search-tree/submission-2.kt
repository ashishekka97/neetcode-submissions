/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        val currVal = root.`val`

        if (p.`val` < currVal && q.`val` < currVal) {
            return lowestCommonAncestor(root.left, p, q)
        }

        if (p.`val` > currVal && q.`val` > currVal) {
            return lowestCommonAncestor(root.right, p, q)
        }

        return root
    }
}
