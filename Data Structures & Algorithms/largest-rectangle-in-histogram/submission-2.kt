class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Pair<Int, Int>>()

        for (i in heights.indices) {
            var start = i

            while (stack.isNotEmpty() && stack.last().first > heights[i]) {
                val (height, index) = stack.removeLast()
                maxArea = maxOf(maxArea, height * (i - index))
                start = index
            }
            
            stack.add(Pair(heights[i], start))
        }

        while (stack.isNotEmpty()) {
            val (height, index) = stack.removeLast()
            maxArea = maxOf(maxArea, height * (heights.size - index))
        }

        return maxArea
    }
}
