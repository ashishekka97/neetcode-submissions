class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val map = mutableMapOf<Char, Int>()
        for (c in s1) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        var start = 0

        for (end in 0 until s2.length) {
            while (end - start + 1 > s1.length) {
                start++
            }
            if (checkFrequencies(map, s2.substring(start, end + 1))) return true
        }

        return false
    }

    fun checkFrequencies(map: Map<Char, Int>, str: String): Boolean {
        val strMap = mutableMapOf<Char, Int>()
        for (ch in str) {
            strMap[ch] = strMap.getOrDefault(ch, 0) + 1
        }
        
        if (map.size != strMap.size) return false
        for (ch in str) {
            if (strMap[ch] != map[ch]) return false
        }
        return true
    }
}
