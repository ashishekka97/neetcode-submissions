class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { str ->
            val freqMap = IntArray(26)
            for (c in str) {
                freqMap[c - 'a']++
            }
            freqMap.contentToString()
        }.values.toList()
    }
}
