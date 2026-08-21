class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        var rows = heights.size
        val cols = heights[0].size

        val fromPacific = mutableSetOf<Pair<Int, Int>>()
        val fromAtlantic = mutableSetOf<Pair<Int, Int>>()

        val dirs = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(row: Int, col: Int, visited: MutableSet<Pair<Int, Int>>) {
            visited.add(Pair(row, col))

            for (d in 0 until 4) {
                val newRow = row + dirs[d]
                val newCol = col + dirs[d + 1]

                if (newRow !in 0 until rows || newCol !in 0 until cols) continue
                if (visited.contains(Pair(newRow, newCol))) continue
                if (heights[newRow][newCol] < heights[row][col]) continue

                dfs(newRow, newCol, visited)
            }
        }

        for (col in 0 until cols) {
            dfs(0, col, fromPacific)
            dfs(rows - 1, col, fromAtlantic)
        }

        for (row in 0 until rows) {
            dfs(row, 0, fromPacific)
            dfs(row, cols - 1, fromAtlantic)
        }

        val result = mutableListOf<List<Int>>()
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val cell = Pair(row, col)
                if (fromPacific.contains(cell) && fromAtlantic.contains(cell)) {
                    result.add(listOf(row, col))
                }
            }
        }

        return result
    }
}
