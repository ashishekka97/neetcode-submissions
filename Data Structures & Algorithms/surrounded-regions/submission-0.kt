class Solution {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size

        val strongRegions = mutableSetOf<Pair<Int, Int>>()
        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int) {
            if (row !in 0 until rows || col !in 0 until cols) return
            if (strongRegions.contains(Pair(row, col))) return
            if (board[row][col] != 'O') return

            strongRegions.add(Pair(row, col))

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                dfs(newRow, newCol)
            }
        }

        for (col in 0 until cols) {
            dfs(0, col)
            dfs(rows - 1, col)
        }

        for (row in 0 until rows) {
            dfs(row, 0)
            dfs(row, cols - 1)
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (board[row][col] == 'O' && !strongRegions.contains(Pair(row, col))) {
                    board[row][col] = 'X'
                }
            }
        }
    }
}
