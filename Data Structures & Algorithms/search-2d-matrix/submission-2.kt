class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size


        var lo = 0
        var hi = m * n - 1


        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            var row = mid / n
            val col = mid % n

            when {
                matrix[row][col] < target -> lo = mid + 1
                matrix[row][col] > target -> hi = mid - 1
                else -> return true
            }
        }

        return false
    }
}
