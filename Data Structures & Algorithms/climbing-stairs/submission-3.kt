class Solution {
    fun climbStairs(n: Int): Int {
        var prev2 = 1
        var prev1 = 1

        for (i in 2..n) {
            val current = prev2 + prev1
            prev2 = prev1
            prev1 = current
        }

        return prev1
    }
}
