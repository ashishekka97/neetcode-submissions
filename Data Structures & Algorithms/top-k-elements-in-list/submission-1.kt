class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            val count = frequencyMap.getOrDefault(num, 0)
            frequencyMap[num] = count + 1 
        }

        val result = frequencyMap.toList().sortedByDescending { (_, value) -> value }.take(k).map { it.first }

        return result.toIntArray()
    }
}
