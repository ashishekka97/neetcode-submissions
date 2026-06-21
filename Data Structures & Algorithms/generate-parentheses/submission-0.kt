class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun dfs(openCount: Int, closeCount: Int, s: StringBuilder) {
            if (s.length == 2 * n) {
                result.add(s.toString())
                return
            }

            if (openCount < n) {
                s.append("(")
                dfs(openCount + 1, closeCount, s)
                s.deleteCharAt(s.length - 1)
            }

            if (closeCount < openCount) {
                s.append(")")
                dfs(openCount, closeCount + 1, s)
                s.deleteCharAt(s.length - 1)
            }
        }

        dfs(0, 0, StringBuilder())
        return result
    }
}
