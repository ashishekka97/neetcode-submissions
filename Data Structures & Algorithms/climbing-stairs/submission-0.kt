class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1

        var prev1 = 1
        var prev2 = 1

        for (i in 2..n) {
            var curr = prev1 + prev2
            prev2 = prev1
            prev1 = curr
        }

        return prev1
    }
}
