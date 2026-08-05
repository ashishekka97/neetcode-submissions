class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        val rows = grid.size
        val cols = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        var freshCount = 0

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 2) {
                    queue.addLast(Pair(row, col))
                } else if (grid[row][col] == 1) {
                    freshCount++
                }
            }
        }

        if (freshCount == 0) return 0

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        var timeTaken = 0
        while (queue.isNotEmpty() && freshCount > 0) {
            val size = queue.size
            for (n in 0 until size) {
                val (row, col) = queue.removeFirst()

                for (i in 0 until 4) {
                    val newRow = row + dirs[i]
                    val newCol = col + dirs[i + 1]

                    if (newRow !in 0 until rows || newCol !in 0 until cols || grid[newRow][newCol] != 1) {
                        continue
                    }

                    grid[newRow][newCol] = 2
                    freshCount--
                    queue.addLast(Pair(newRow, newCol))
                }
            }
            timeTaken += 1
        }

        return if (freshCount == 0) timeTaken else -1
    }
}
