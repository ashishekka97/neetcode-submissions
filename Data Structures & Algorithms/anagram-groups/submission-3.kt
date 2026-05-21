class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.getAnagramKey() }.values.toList()
    }

    fun String.getAnagramKey(): String {
        val frequencyMap = IntArray(26)
        forEach { char ->
            frequencyMap[char - 'a']++
        }
        return frequencyMap.contentToString()
    }
}
