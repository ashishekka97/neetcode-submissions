class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var start = 0
        val counts = mutableMapOf<Char, Int>()
        var maxCount = 0
        var result = 0

        for (end in 0 until s.length) {
            val ch = s[end]
            counts[ch] = counts.getOrDefault(ch, 0) + 1
            maxCount = maxOf(maxCount, counts[ch]!!)

            while (end - start + 1 - maxCount > k) {
                counts[s[start]] = counts[s[start]]!! - 1
                start++
            }

            result = maxOf(result, end - start + 1)
        }

        return result
    }
}
