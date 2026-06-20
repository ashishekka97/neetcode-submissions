/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        val inOrderMap = inorder.withIndex().associate { it.value to it.index }
        var preIndex = 0

        fun construct(inStart: Int, inEnd: Int): TreeNode? {
            if (inStart > inEnd) return null

            val preVal = preorder[preIndex++]
            val root = TreeNode(preVal)
            val inIndex = inOrderMap[preVal]!!

            root.left = construct(inStart, inIndex - 1)
            root.right = construct(inIndex + 1, inEnd)

            return root
        }

        return construct(0, inorder.lastIndex)
    }
}
