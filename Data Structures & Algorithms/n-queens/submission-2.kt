class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val cols = mutableSetOf<Int>()
        val posDiag = mutableSetOf<Int>()
        val negDiag = mutableSetOf<Int>()

        val result = mutableListOf<List<String>>()
        val board = MutableList(n) {
            MutableList(n) { "." }
        }

        fun backtrack(row: Int) {
            if (row == n) {
                val res = mutableListOf<String>()
                for (r in board.indices) {
                    res.add(board[r].joinToString(""))
                }
                result.add(res)
                return
            }

            for (col in 0 until n) {
                if (col in cols || row + col in posDiag || row - col in negDiag) {
                    continue
                }

                board[row][col] = "Q"
                cols.add(col)
                posDiag.add(row + col)
                negDiag.add(row - col)

                backtrack(row + 1)

                board[row][col] = "."
                cols.remove(col)
                posDiag.remove(row + col)
                negDiag.remove(row - col)
            }
        }

        backtrack(0)
        return result
    }
}
