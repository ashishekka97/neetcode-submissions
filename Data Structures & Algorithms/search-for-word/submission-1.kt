class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (board[r][c] == word[0]) {
                    if (dfs(board, r, c, word, 0)) {
                        return true
                    }
                }
            }
        }

        return false
    }

    fun dfs(
        board: Array<CharArray>,
        row: Int,
        col: Int,
        word: String,
        index: Int
    ): Boolean {
        if (index == word.length) return true

        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size) return false

        if (board[row][col] != word[index]) return false

        val temp = board[row][col]
        board[row][col] = '#'

        val isFound = dfs(board, row + 1, col, word, index + 1) ||
            dfs(board, row, col - 1, word, index + 1) ||
            dfs(board, row - 1, col, word, index + 1) ||
            dfs(board, row, col + 1, word, index + 1)

        board[row][col] = temp

        return isFound
    }
}
