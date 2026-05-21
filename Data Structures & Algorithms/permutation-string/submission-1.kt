class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1Count = mutableMapOf<Char, Int>()

        for (ch in s1) {
            s1Count[ch] = s1Count.getOrDefault(ch, 0) + 1
        }

        val s2Count = mutableMapOf<Char, Int>()
        var matches = 0
        for (end in s2.indices) {
            val chIn = s2[end]
            s2Count[chIn] = s2Count.getOrDefault(chIn, 0) + 1

            if (s2Count[chIn] == s1Count[chIn]) {
                matches++
            } else if (s2Count[chIn] == s1Count.getOrDefault(chIn, 0) + 1) {
                matches--
            }

            if (end >= s1.length) {
                val chOut = s2[end - s1.length]

                if (s2Count[chOut] == s1Count[chOut]) {
                    matches--
                } else if (s2Count[chOut] == s1Count.getOrDefault(chOut, 0) + 1) {
                    matches++
                }

                s2Count[chOut] = s2Count[chOut]!! - 1
            }

            if (matches == s1Count.size) return true
        }

        return false
    }
}
