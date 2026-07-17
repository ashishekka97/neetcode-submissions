class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freqMap = mutableMapOf<Char, Int>()
        var result = 0
        var maxFreq = 0

        var start = 0
        for (end in 0 until s.length) {
            val ch = s[end]
            freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1
            maxFreq = maxOf(maxFreq, freqMap[ch]!!)

            while (end - start + 1 - maxFreq > k) {
                val startCh = s[start]
                freqMap[startCh] = freqMap[startCh]!! - 1
                if (freqMap[startCh]!! < 0) freqMap.remove(startCh)
                start++
            }

            result = maxOf(result, end - start + 1)
        }

        return result
    }
}
