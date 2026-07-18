class Solution {
    fun minWindow(s: String, t: String): String {
        if (t == "") return ""
        val tFrequencies = mutableMapOf<Char, Int>()
        for (ch in t) {
            tFrequencies[ch] = tFrequencies.getOrDefault(ch, 0) + 1
        }

        val sFrequencies = mutableMapOf<Char, Int>()
        var start = 0
        var result = intArrayOf(Integer.MAX_VALUE, 0, 0)

        val need = tFrequencies.size
        var have = 0

        for (end in 0 until s.length) {
            val ch = s[end]
            sFrequencies[ch] = sFrequencies.getOrDefault(ch, 0) + 1

            if (tFrequencies.contains(ch) && sFrequencies[ch]!! == tFrequencies[ch]) {
                have++
            }

            while (have == need) {
                if (end - start + 1 < result[0]) {
                    result[0] = end - start + 1
                    result[1] = start
                    result[2] = end
                }

                sFrequencies[s[start]] = sFrequencies[s[start]]!! - 1

                if (tFrequencies.contains(s[start]) && sFrequencies[s[start]]!! < tFrequencies[s[start]]!!) {
                    have--
                }
                start++
            }
        }

        if (result[0] == Integer.MAX_VALUE) return ""
        else return s.substring(result[1], result[2] + 1)
    }
}
