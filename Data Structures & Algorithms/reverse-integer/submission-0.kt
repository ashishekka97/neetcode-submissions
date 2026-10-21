class Solution {
    fun reverse(x: Int): Int {
        val res = rec(Math.abs(x), 0L) * if (x < 0) -1 else 1
        return if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) 0 else res.toInt()
    }

    private fun rec(n: Int, rev: Long): Long {
        if (n == 0) return rev
        return rec(n / 10, rev * 10 + n % 10)
    }
}
