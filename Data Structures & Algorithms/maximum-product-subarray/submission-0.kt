class Solution {
    fun maxProduct(nums: IntArray): Int {
        var res = nums[0]
        var currMax = 1
        var currMin = 1

        for (num in nums) {
            val temp = currMax * num
            currMax = maxOf(num, temp, currMin * num)
            currMin = minOf(num, temp, currMin * num)
            res = maxOf(res, currMax)
        }

        return res
    }
}
