class Solution {
    fun maxArea(heights: IntArray): Int {
        var start = 0
        var end = heights.size - 1

        var max = Integer.MIN_VALUE
        while (start < end) {
            val b = end - start
            val h = minOf(heights[start], heights[end])
            val area = b * h
            max = maxOf(max, area)
            if (heights[start] < heights[end]) {
                start++
            } else {
                end--
            }
        }

        return max
    }
}
