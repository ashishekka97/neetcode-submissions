class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        if (s1.length + s2.length != s3.length) return false

        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) { -1 } }

        fun calculate(i: Int, j: Int, k: Int): Boolean {
            if (k == s3.length) {
                return i == s1.length && j == s2.length
            }

            if (dp[i][j] != -1) return dp[i][j] == 1

            
            if (i < s1.length && s1[i] == s3[k]) {
                if (calculate(i + 1, j, k + 1)) {
                    dp[i][j] = 1
                }
            }

            if (j < s2.length && s2[j] == s3[k]) {
                if (calculate(i, j + 1, k + 1)) {
                    dp[i][j] = 1
                }
            }

            if (dp[i][j] == -1) {
                dp[i][j] = 0
            }
            return dp[i][j] == 1
        }

        return calculate(0, 0, 0)
    }
}
