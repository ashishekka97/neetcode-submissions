class Solution {
    fun maxArea(heights: IntArray): Int {
        var start = 0
        var end = heights.size - 1

        var maxWater = Int.MIN_VALUE

        while (start < end) {
            val b = end - start
            val h = if (heights[start] < heights[end]) {
                heights[start++]
            } else {
                heights[end--]
            }

            maxWater = maxOf(maxWater, b * h)
        }

        return maxWater
    }
}
