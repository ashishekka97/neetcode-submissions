class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        var freshCount = 0
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 2) {
                    queue.addLast(Pair(row, col))
                } else if (grid[row][col] == 1) {
                    freshCount += 1
                }
            }
        }

        if (freshCount == 0) return 0

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        var time = 0
        while (queue.isNotEmpty() && freshCount > 0) {
            repeat(queue.size) {
                val (row, col) = queue.removeFirst()

                for (d in 0 until 4) {
                    val newRow = row + dirs[d]
                    val newCol = col + dirs[d + 1]

                    if (newRow !in 0 until rows || newCol !in 0 until cols) continue
                    if (grid[newRow][newCol] != 1) continue

                    grid[newRow][newCol] = 2
                    freshCount--
                    queue.addLast(Pair(newRow, newCol))
                }
            }
            time++
        }

        if (freshCount == 0) return time
        return -1
    }
}
