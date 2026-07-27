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

        fun dfs(node: TreeNode?) {
            if (node == null) {
                result.add("N")
                return
            }
            
            result.add(node.`val`.toString())

            dfs(node.left)
            dfs(node.right)
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
            val node = TreeNode(value.toIntOrNull() ?: 0)
            node.left = dfs()
            node.right = dfs()
            return node
        }
        return dfs()
    }
}
