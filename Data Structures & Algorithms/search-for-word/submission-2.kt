class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int, wordIndex: Int): Boolean {
            if (wordIndex == word.length) {
                return true
            }

            if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word[wordIndex]) {
                return false
            }

            val ch = board[row][col]
            board[row][col] = '#'

            var found = false
            for (dir in 0 until 4) {
                val newRow = row + dirs[dir]
                val newCol = col + dirs[dir + 1]
                found = found || dfs(newRow, newCol, wordIndex + 1)
            }

            board[row][col] = ch
            return found
        }

        for (row in 0 until m) {
            for (col in 0 until n) {
                if (board[row][col] == word[0]) {
                    if (dfs(row, col, 0)) {
                        return true
                    }
                }
            }
        }

        return false
    }
}
