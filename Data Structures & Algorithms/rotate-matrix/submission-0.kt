class Solution {
    fun rotate(matrix: Array<IntArray>) {
        matrix.reverse()

        for (i in matrix.indices) {
            for (j in i + 1 until matrix.size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}
