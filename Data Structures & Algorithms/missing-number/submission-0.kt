class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        var xorr = n
        for (i in 0 until n) {
            xorr = xorr xor i xor nums[i]
        }

        return xorr
    }
}
