class Solution {
    fun minWindow(s: String, t: String): String {
        val tCounts = mutableMapOf<Char, Int>()
        for (ch in t) {
            tCounts[ch] = tCounts.getOrDefault(ch, 0) + 1       
        }

        val sCounts = mutableMapOf<Char, Int>()

        var result = intArrayOf(Int.MAX_VALUE, 0, 0)

        var have = 0
        val need = tCounts.size

        var start = 0
        for (end in s.indices) {
            val chIn = s[end]
            sCounts[chIn] = sCounts.getOrDefault(chIn, 0) + 1

            if (tCounts.containsKey(chIn) && tCounts[chIn]!! == sCounts[chIn]!!) {
                have++
            }

            while (have == need) {
                val chOut = s[start]

                if (tCounts.containsKey(chOut) && tCounts[chOut]!! == sCounts[chOut]!!) {
                    have--
                }

                if (end - start + 1 < result[0]) {
                    result[0] = end - start + 1
                    result[1] = start
                    result[2] = end
                }

                sCounts[chOut] = sCounts[chOut]!! - 1
                start++
            }
        }

        if (result[0] == Int.MAX_VALUE) return ""
        return s.substring(result[1], result[2] + 1)
    }
}
