class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val visited = Array<BooleanArray>(rows) { BooleanArray(cols) }
        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int) {
            visited[row][col] = true

            for (dir in 0 until 4) {
                val newRow = row + dirs[dir]
                val newCol = col + dirs[dir + 1]

                if (newRow in 0 until rows && newCol in 0 until cols && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    dfs(newRow, newCol)
                }
            }
        }

        var numIslands = 0

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs(row, col)
                    numIslands++
                }
            }
        }

        return numIslands
    }
}
