class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val rows = grid.size
        val cols = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 0) {
                    queue.addLast(Pair(row, col))
                }
            }
        }

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        while (queue.isNotEmpty()) {
            val (row, col) = queue.removeFirst()

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                if (newRow !in 0 until rows || newCol !in 0 until cols || grid[newRow][newCol] != Int.MAX_VALUE) {
                    continue
                }

                grid[newRow][newCol] = grid[row][col] + 1
                queue.addLast(Pair(newRow, newCol))
            }
        }
    }
}
