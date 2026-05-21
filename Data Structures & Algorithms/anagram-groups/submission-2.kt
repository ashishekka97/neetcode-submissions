class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.getAnagramKey() }.values.toList()
    }

    fun String.getAnagramKey(): String {
        val charCount = sortedMapOf<Char, Int>()

        forEach { c: Char ->
            val count: Int = charCount.getOrDefault(c, 0)
            charCount[c] = count + 1
        }

        val key = charCount.entries.fold("") { acc, entry ->
            val char = entry.key
            val count = entry.value
            val charCount = "${char}_${count}"
            acc + charCount
        }

        return key
    }
}
