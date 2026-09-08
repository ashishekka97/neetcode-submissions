class Solution {
    fun climbStairs(n: Int): Int {
        var prev1 = 1
        var prev2 = 1

        for (i in 2..n) {
            val curr = prev1 + prev2
            prev2 = prev1
            prev1 = curr
        }

        return prev1
    }
}
