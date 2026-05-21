class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.size - 1

        while (start < end) {
            val sum = numbers[start] + numbers[end]
            if (sum > target) {
                end--
            } else if (sum < target) {
                start++
            } else {
                return intArrayOf(start + 1, end + 1)
            }
        }

        return IntArray(2)
    }
}
