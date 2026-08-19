class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val visited = Array(rows) { BooleanArray(cols) }
        var maxArea = 0

        val dirs = intArrayOf(0, 1, 0, -1, 0)
        fun dfs(row: Int, col: Int): Int {
            visited[row][col] = true
            var count = 1

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                if (newRow in 0 until rows && newCol in 0 until cols && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    count += dfs(newRow, newCol)
                }
            }

            return count
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    maxArea = maxOf(maxArea, dfs(row, col))
                }
            }
        }

        return maxArea
    }
}
