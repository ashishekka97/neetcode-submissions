class Solution {
    fun partitionLabels(s: String): List<Int> {
        val map = mutableMapOf<Char, Int>()

        for ((i, c) in s.withIndex()) {
            val lastIndex = map[c] ?: -1
            if (i > lastIndex) {
                map[c] = i
            }
        }

        var size = 0
        var end = 0
        val result = mutableListOf<Int>()

        for ((i, c) in s.withIndex()) {
            size++
            end = maxOf(end, map[c] ?: 0)

            if (i == end) {
                result.add(size)
                size = 0
            }
        }

        return result
    }
}
