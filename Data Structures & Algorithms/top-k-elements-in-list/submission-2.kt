class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val buckets = Array<MutableList<Int>?>(nums.size + 1) { null }
        for ((num, freq) in frequencyMap) {
            if (buckets[freq] == null) {
                buckets[freq] = mutableListOf()
            }
            buckets[freq]!!.add(num)
        }

        val result = IntArray(k)
        var index = 0
        for (i in buckets.indices.reversed()) {
            if (buckets[i] != null) {
                for (num in buckets[i]!!) {
                    result[index++] = num
                    if (index == k) return result
                }
            }
        }

        return result
    }
}
