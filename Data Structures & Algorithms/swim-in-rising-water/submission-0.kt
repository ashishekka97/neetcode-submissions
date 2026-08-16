class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val visited = mutableSetOf<Pair<Int, Int>>()

        val directions = intArrayOf(0, 1, 0, -1, 0)

        val minHeap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        minHeap.offer(Triple(grid[0][0], 0, 0))
        visited.add(Pair(0, 0))

        while (minHeap.isNotEmpty()) {
            val (height, row, col) = minHeap.poll()

            if (row == n - 1 && col == n - 1) return height

            for (d in 0 until 4) {
                val newRow = row + directions[d]
                val newCol = col + directions[d + 1]

                if (newRow !in 0 until n || newCol !in 0 until n || visited.contains(Pair(newRow, newCol))) {
                    continue
                }

                minHeap.offer(
                    Triple(
                        maxOf(grid[newRow][newCol], height),
                        newRow,
                        newCol
                    )
                )
                visited.add(Pair(newRow, newCol))
            }
        }

        return -1
    }
}
