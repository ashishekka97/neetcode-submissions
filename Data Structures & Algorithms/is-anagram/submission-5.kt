class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        for (c in t) {
            if (map.contains(c)) {
                val value = map[c]!!
                if (value > 1) {
                    map[c] = value - 1
                } else {
                    map.remove(c)
                }
            } else {
                return false
            }
        }

        if (!map.isEmpty()) return false
        return true
    }
}
