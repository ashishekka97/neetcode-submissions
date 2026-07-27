/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderMap = inorder.withIndex().associate { it.value to it.index }
        var preorderIndex = 0

        fun build(inStart: Int, inEnd: Int): TreeNode? {
            if (inStart > inEnd) return null

            val root = TreeNode(preorder[preorderIndex++])
            val inorderIndex = inorderMap[root.`val`]!!
            root.left = build(inStart, inorderIndex - 1)
            root.right = build(inorderIndex + 1, inEnd)

            return root
        }

        return build(0, inorder.lastIndex)
    }
}
