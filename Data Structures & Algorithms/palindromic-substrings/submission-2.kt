class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length

        fun expandFromCenter(start: Int, end: Int): Int {
            var left = start
            var right = end
            var count = 0
            while (left >= 0 && right < n && s[left] == s[right]) {
                count += 1
                left -= 1
                right += 1
            }

            return count
        }

        var result = 0

        for (i in 0 until n) {
            result += expandFromCenter(i, i)
            result += expandFromCenter(i, i + 1)
        }

        return result
    }
}
