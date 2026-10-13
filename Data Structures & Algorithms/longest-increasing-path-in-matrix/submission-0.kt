class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        val memo = Array(rows) { IntArray(cols) }

        fun calculate(r: Int, c: Int, prev: Int): Int {
            if (r !in 0 until rows || c !in 0 until cols || matrix[r][c] <= prev) {
                return 0
            }

            if (memo[r][c] != 0) return memo[r][c]

            var res = 1
            for (d in 0 until 4) {
                val newRow = r + dirs[d]
                val newCol = c + dirs[d + 1]

                res = maxOf(res, 1 + calculate(newRow, newCol, matrix[r][c]))
            }

            memo[r][c] = res
            return memo[r][c]
        }

        var lip = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                lip = maxOf(lip, calculate(r, c, Int.MIN_VALUE))
            }
        }

        return lip
    }
}
