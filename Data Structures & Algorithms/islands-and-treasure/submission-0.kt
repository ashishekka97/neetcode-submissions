class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val rows = grid.size
        val cols = grid[0].size

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int, distance: Int) {
            val currentDistance = grid[row][col]
            grid[row][col] = minOf(currentDistance, distance)

            for (i in 0 until 4) {
                val newRow = row + dirs[i]
                val newCol = col + dirs[i + 1]

                if (newRow in 0 until rows && newCol in 0 until cols) {
                    val newDistance = grid[newRow][newCol]
                    if (grid[newRow][newCol] >= 0 && newDistance > distance + 1) {
                        dfs(newRow, newCol, distance + 1)
                    }
                }
            }           
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 0) {
                    dfs(row, col, 0)
                }
            }
        }
    }
}
