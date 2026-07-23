/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        fun isValidBST(node: TreeNode?, left: Int, right: Int): Boolean {
            if (node == null) return true

            if (!(node.`val` > left && node.`val` < right)) return false
            return isValidBST(node.left, left, node.`val`) && isValidBST(node.right, node.`val`, right)
        }

        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}
