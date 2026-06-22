class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0

        for (n in nums) {
            val curr = maxOf(n + rob1, rob2)
            rob1 = rob2
            rob2 = curr
        }

        return rob2
    }
}
