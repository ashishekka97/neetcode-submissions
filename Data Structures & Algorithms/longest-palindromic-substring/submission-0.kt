class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length

        fun expandFromCenter(left: Int, right: Int): IntArray {
            var start = left
            var end = right
            while (start >= 0 && end < n && s[start] == s[end]) {
                start -= 1
                end += 1
            }

            return intArrayOf(start + 1, end, end - start)
        }

        var longestPair = intArrayOf(0, 0, 0)
        for (i in 0 until n) {
            val odd = expandFromCenter(i, i)
            val even = expandFromCenter(i, i + 1)

            val currentBest = if (odd[2] > even[2]) odd else even

            if (currentBest[2] > longestPair[2]) {
                longestPair = currentBest
            }
        }

        return s.substring(longestPair[0], longestPair[1])
    }
}
