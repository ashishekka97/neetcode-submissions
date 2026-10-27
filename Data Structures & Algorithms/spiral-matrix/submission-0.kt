class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size

        var left = 0
        var right = n
        var top = 0
        var bottom = m

        val result = mutableListOf<Int>()

        while (left < right && top < bottom) {
            for (i in left until right) {
                result.add(matrix[top][i])
            }
            top += 1

            for (i in top until bottom) {
                result.add(matrix[i][right - 1])
            }
            right -= 1

            if (!(left < right && top < bottom)) {
                break
            }

            for (i in right - 1 downTo left) {
                result.add(matrix[bottom - 1][i])
            }
            bottom -= 1

            for (i in bottom - 1 downTo top) {
                result.add(matrix[i][left])
            }
            left += 1
        }

        return result
    }
}
