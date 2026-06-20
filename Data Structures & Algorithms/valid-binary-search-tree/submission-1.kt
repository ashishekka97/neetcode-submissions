/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

        fun isValid(root: TreeNode?, left: Int, right: Int): Boolean {
            if (root == null) return true
            if (!(root.`val` > left && root.`val` < right)) return false
            return isValid(root.left, left, root.`val`) && isValid(root.right, root.`val`, right)
        }

        return isValid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}
