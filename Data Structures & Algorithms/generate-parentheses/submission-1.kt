class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun dfs(path: StringBuilder, opens: Int, closes: Int) {
            if (path.length == 2 * n) {
                result.add(path.toString())
                return
            }

            if (opens < n) {
                path.append("(")
                dfs(path, opens + 1, closes)
                path.deleteCharAt(path.length - 1)
            }

            if (closes < opens) {
                path.append(")")
                dfs(path, opens, closes + 1)
                path.deleteCharAt(path.length - 1)
            }
        }

        dfs(StringBuilder(), 0, 0)
        return result
    }
}
