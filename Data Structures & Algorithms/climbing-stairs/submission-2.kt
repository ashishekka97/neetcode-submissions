class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        var prev2 = 0
        var prev1 = 1

        for (i in 1..n) {
            val current = prev2 + prev1
            prev2 = prev1
            prev1 = current
        }

        return prev1
    }
}
