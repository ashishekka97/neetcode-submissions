class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dict = wordDict.toSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        for(i in 1..s.length) {
            for (j in 0 until i) {
                if (dp[j] && s.substring(j, i) in dict) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[s.length]
    }
}
