class Solution {
    fun numDistinct(s: String, t: String): Int {
        val m = s.length
        val n = t.length

        if (n > m) return 0

        val memo = Array(m) { IntArray(n) { -1 } }

        fun calculate(i: Int, j: Int): Int {
            if (j == n) return 1

            if (i == m) return 0

            if (memo[i][j] != -1) return memo[i][j]

            var res = calculate(i + 1, j)
            if (s[i] == t[j]) {
                res += calculate(i + 1, j + 1)
            }
            memo[i][j] = res
            return memo[i][j]
        }

        return calculate(0, 0)
    }
}
