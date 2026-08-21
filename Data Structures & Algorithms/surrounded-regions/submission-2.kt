class Solution {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int) {
            board[row][col] = 'T'

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                if (newRow !in 0 until rows || newCol !in 0 until cols) continue
                if (board[newRow][newCol] != 'O') continue
                dfs(newRow, newCol)
            }
        }

        for (row in 0 until rows) {
            if (board[row][0] == 'O') dfs(row, 0)
            if (board[row][cols - 1] == 'O') dfs(row, cols - 1)
        }

        for (col in 0 until cols) {
            if (board[0][col] == 'O') dfs(0, col)
            if (board[rows - 1][col] == 'O') dfs(rows - 1, col)
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X'
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O'
                }
            }
        }
    }
}
