class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var lo = 1
        var hi = piles.max()

        var bestSpeed = hi

        while (lo <= hi) {
            val speed = lo + (hi - lo) / 2

            if (canEatAllPiles(piles, h, speed)) {
                bestSpeed = minOf(bestSpeed, speed)
                // Look for a better (lower) speed
                hi = speed - 1
            } else {
                lo = speed + 1
            }
        }

        return bestSpeed
    }

    private fun canEatAllPiles(
        piles: IntArray,
        duration: Int,
        speed: Int
    ): Boolean {
        var hour = 0

        for (i in 0 until piles.size) {
            val fruits = piles[i]
            val time = fruits / speed
            hour += time

            if (fruits - (speed * time) > 0) hour += 1

            if (hour > duration) return false
        }

        return true
    }
}
