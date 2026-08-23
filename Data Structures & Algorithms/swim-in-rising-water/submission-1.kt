class Solution {
    data class Cell(val row: Int, val col: Int, val maxElevation: Int): Comparable<Cell> {
            override fun compareTo(other: Cell) = this.maxElevation.compareTo(other.maxElevation)
        }


    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val visited = Array(n) { BooleanArray(n) }

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        val queue = PriorityQueue<Cell>()
        queue.offer(Cell(0, 0, grid[0][0]))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (r, c, maxElevation) = queue.poll()

            if (r == n - 1 && c == n - 1) return maxElevation

            for (d in 0 until 4) {
                val nr = r + dirs[d]
                val nc = c + dirs[d + 1]

                if (nr in 0 until n && nc in 0 until n && !visited[nr][nc]) {
                    visited[nr][nc] = true
                    queue.offer(Cell(nr, nc, maxOf(maxElevation, grid[nr][nc])))
                }
            }
        }

        return -1
    }
}
