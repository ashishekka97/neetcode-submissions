/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        
        fun isValid(node: TreeNode?, left: Int, right: Int): Boolean {
            if (node == null) return true
            if (!(node.`val` > left && node.`val` < right)) return false
            return isValid(node.left, left, node.`val`) &&
                isValid(node.right, node.`val`, right)
        }

        return isValid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}
