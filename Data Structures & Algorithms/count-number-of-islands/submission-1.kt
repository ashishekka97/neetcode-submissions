class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val visited = Array(rows) { BooleanArray(cols) }

        var count = 0

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int) {
            visited[row][col] = true

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                if (newRow !in 0 until rows) continue
                if (newCol !in 0 until cols) continue
                if (grid[newRow][newCol] != '1') continue
                if (visited[newRow][newCol]) continue

                dfs(newRow, newCol)
            }
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs(row, col)
                    count += 1
                }
            }
        }

        return count
    }
}
