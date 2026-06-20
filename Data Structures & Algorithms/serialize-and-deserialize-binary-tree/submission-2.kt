/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val result = mutableListOf<String>()

        fun dfs(root: TreeNode?) {
            if (root == null) {
                result.add("N")
                return
            }

            result.add(root.`val`.toString())
            dfs(root.left)
            dfs(root.right)
        }
        dfs(root)

        return result.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val input = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            val value = input[i++]
            if (value == "N") return null

            val root = TreeNode(value.toIntOrNull() ?: 0)
            root.left = dfs()
            root.right = dfs()
            return root
        }

        return dfs()
    }
}
