class CountSquares {

    val plane = Array(1001) {
        IntArray(1001)
    }

    val dirs = arrayOf<IntArray>(
        intArrayOf(1, 1),
        intArrayOf(1, -1),
        intArrayOf(-1, 1),
        intArrayOf(-1, -1)
    )

    fun add(point: IntArray) {
        val x = point[0]
        val y = point[1]

        plane[x][y]++
    }

    fun count(point: IntArray): Int {
        val x = point[0]
        val y = point[1]

        var squares = 0

        for (size in 1..1000) {
            for (dir in dirs) {
                val newX = x + (size * dir[0])
                val newY = y + (size * dir[1])

                if (newX !in 0 until plane.size || newY !in 0 until plane.size) continue

                
                val count1 = plane[newX][newY]
                if (count1 == 0) continue

                
                val count2 = plane[newX][y]

                val count3 = plane[x][newY]

                squares += count1 * count2 * count3
            }
        }

        return squares
    }
}
