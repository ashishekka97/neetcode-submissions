class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var start = 0
        var end = 0

        val frequencies = mutableMapOf<Char, Int>()
        var result = 0

        while (end < s.length) {
            val ch = s[end]
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
            val maxFrequency = frequencies.values.maxOf { it }

            while (end - start + 1 - maxFrequency > k) {
                val startCh = s[start]
                frequencies[startCh] = frequencies[startCh]!! - 1
                start++
            }
            result = maxOf(result, end - start + 1)
            end++
        }

        return result
    }
}