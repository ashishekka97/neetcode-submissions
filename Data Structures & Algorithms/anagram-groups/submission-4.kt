class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { getAnagramKey(it) }.values.toList()
    }

    fun getAnagramKey(str: String): String {
        val counts = IntArray(26)

        for (c in str) {
            counts[c - 'a']++
        }

        return counts.contentToString()
    }
}
