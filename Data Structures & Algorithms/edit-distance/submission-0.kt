class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = Array(m) { IntArray(n) { -1 } }

        fun computeDistance(index1: Int, index2: Int): Int {
            if (index1 < 0) return index2 + 1
            if (index2 < 0) return index1 + 1

            if (dp[index1][index2] == -1) {
                if (word1[index1] == word2[index2]) {
                    dp[index1][index2] = computeDistance(index1 - 1, index2 - 1)
                } else {
                    val substituteLast = computeDistance(index1 - 1, index2 - 1)
                    val addLast = computeDistance(index1, index2 - 1)
                    val removeLast = computeDistance(index1 - 1, index2)
                    
                    dp[index1][index2] = 1 + minOf(substituteLast, addLast, removeLast)
                }
            }

            return dp[index1][index2]
        }

        return computeDistance(m - 1, n - 1)
    }
}
