class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0

        var longest = 0
        val set = mutableSetOf<Char>()

        for (end in 0 until s.length) {
            val ch = s[end]

            while (set.contains(ch)) {
                set.remove(s[start++])
            }

            set.add(ch)
            longest = maxOf(longest, end - start + 1)
        }

        return longest
    }
}
