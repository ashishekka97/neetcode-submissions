class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = MutableList(n) {
            MutableList(n) { "." }
        }

        val cols = mutableSetOf<Int>()
        val posDiag = mutableSetOf<Int>()
        val negDiag = mutableSetOf<Int>()

        fun backtrack(row: Int) {
            if (row == n) {
                val res = mutableListOf<String>()
                for (r in board.indices) {
                    res.add(board[r].joinToString(""))
                }
                result.add(res.toList())
                return
            }

            for (col in board[0].indices) {
                if (col in cols || (row + col) in posDiag || (row - col) in negDiag) {
                    continue
                }

                board[row][col] = "Q"
                cols.add(col)
                posDiag.add(row + col)
                negDiag.add(row - col)

                backtrack(row + 1)

                negDiag.remove(row - col)
                posDiag.remove(row + col)
                cols.remove(col)
                board[row][col] = "."
            }
        }

        backtrack(0)
        return result
    }
}
