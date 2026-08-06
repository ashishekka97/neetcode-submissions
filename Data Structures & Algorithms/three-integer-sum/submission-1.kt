class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sorted()

        var i = 0
        val n = sortedNums.size
        val result = mutableListOf<List<Int>>()
        while (i < n) {
            var start = i + 1
            var end = n - 1
            while (start < end) {
                val sum = sortedNums[i] + sortedNums[start] + sortedNums[end]
                if (sum > 0) {
                    end--
                } else if (sum < 0) {
                    start++
                } else {
                    result.add(listOf(sortedNums[i], sortedNums[start], sortedNums[end]))
                    while (start < end && sortedNums[start + 1] == sortedNums[start]) start++
                    while (end > start && sortedNums[end - 1] == sortedNums[end]) end--
                    start++
                    end--
                }
            }
            while (i < n - 1 && sortedNums[i + 1] == sortedNums[i]) i++
            i++
        }
        return result
    }
}