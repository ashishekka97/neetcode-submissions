class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length

        val memo = Array(m + 1) { IntArray(n + 1) { - 1} }


        fun matches(i: Int, j: Int): Boolean {
            if (j == n) return i == m

            if (memo[i][j] != -1) return memo[i][j] == 1

            val match = i < m && (s[i] == p[j] || p[j] == '.')

            if ((j + 1) < n && p[j + 1] == '*') {
                memo[i][j] = if (matches(i, j + 2) || (match && matches(i + 1, j))) 1 else 0
                return memo[i][j] == 1
            }

            if (match) {
                memo[i][j] = if (matches(i + 1, j + 1)) 1 else 0
                return memo[i][j] == 1
            }

            memo[i][j] = 0
            return false
        }

        return matches(0, 0)
    }
}
