class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = mutableListOf<Pair<Int, Int>>()

        for (i in heights.indices) {
            var start = i

            while (stack.isNotEmpty() && stack.last().first > heights[i]) {
                val (height, index) = stack.removeLast()
                maxArea = maxOf(maxArea, height * (i - index))
                start = index
            }
            stack.addLast(Pair(heights[i], start))
        }

        for (i in stack.indices) {
            val (height, index) = stack[i]
            maxArea = maxOf(maxArea, height * (heights.size - index))
        }

        return maxArea
    }
}
