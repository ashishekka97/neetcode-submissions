class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) { BooleanArray(n) }

        var result = 0

        for (i in 0 until n) {
            dp[i][i] = true
            result += 1
        }

        for (right in 1 until n) {
            for (left in 0 until right) {
                if (s[left] == s[right]) {
                    if (right - left == 1 || dp[left + 1][right - 1]) {
                        dp[left][right] = true
                        result += 1
                    }
                }
            }
        }

        return result
    }
}
