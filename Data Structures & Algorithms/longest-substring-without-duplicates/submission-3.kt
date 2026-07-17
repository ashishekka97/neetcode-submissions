class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()

        var start = 0
        var longest = 0
        for (end in 0 until s.length) {
            val ch = s[end]

            while (charSet.contains(ch)) {
                charSet.remove(s[start++])
            }

            charSet.add(ch)
            longest = maxOf(longest, end - start + 1)
        }

        return longest
    }
}
