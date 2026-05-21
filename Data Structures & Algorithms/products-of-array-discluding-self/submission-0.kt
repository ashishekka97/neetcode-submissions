class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixProducts = IntArray(nums.size) { 1 }
        val suffixProducts = IntArray(nums.size) { 1 }
        val result = IntArray(nums.size) { 1 }

        var prod = 1
        var i = 1
        while (i < nums.size) {
            prod *= nums[i - 1] 
            prefixProducts[i] = prod
            i++
        }

        prod = 1
        i = nums.size - 2
        while (i >= 0) {
            prod *= nums[i + 1] 
            suffixProducts[i] = prod
            i--
        }
        
        i = 0
        while (i < nums.size) {
            result[i] = prefixProducts[i] * suffixProducts[i]
            i++
        }

        return result
    }
}