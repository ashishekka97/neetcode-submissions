class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var result = 0

        val charSet = mutableSetOf<Char>()

        for (end in 0 until s.length) {
            val ch = s[end]
            if (charSet.contains(ch)) {
                while (charSet.contains(ch)) {
                    charSet.remove(s[start])
                    start++
                }
            }
            charSet.add(ch)
            result = maxOf(result, charSet.size)
        }

        return result
    }
}
