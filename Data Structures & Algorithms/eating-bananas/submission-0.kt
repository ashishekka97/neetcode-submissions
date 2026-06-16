class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var start = 1
        var end = piles.maxOrNull() ?: 1

        var rate = end

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (canEat(piles, mid, h)) {
                rate = mid
                end = mid - 1 // Try for smaller rates
            } else {
                start = mid + 1
            }
        }

        return rate
    }

    private fun canEat(piles: IntArray, rate: Int, h: Int): Boolean {
        var time = 0

        for (pile in piles) {
            // Ceiling division logic remains the same
            time += (pile + rate - 1) / rate
        }

        return time <= h
    }
}
