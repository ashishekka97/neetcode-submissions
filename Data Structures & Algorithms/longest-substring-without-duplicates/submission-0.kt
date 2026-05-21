class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var max = 0

        val state = mutableSetOf<Char>()

        while (end < s.length) {
            val ch = s[end]
            if (state.contains(ch)) {
                while (state.contains(ch)) {
                    state.remove(s[start])
                    start++
                }
            }
            state.add(ch)
            max = maxOf(state.size, max)
            end++
        }

        return max
    }
}
