class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)

        var i = 1
        var max = 0
        while (i < height.size) {
            max = maxOf(height[i - 1], max)
            leftMax[i] = max
            i++
        }


        i = height.size - 2
        max = 0
        while (i >= 0) {
            max = maxOf(height[i + 1], max)
            rightMax[i] = max
            i--
        }

        max = 0
        i = 0
        var sum = 0
        while (i < height.size) {
            val left = leftMax[i]
            val right = rightMax[i]
            val trapped = minOf(left, right) - height[i]
            if (trapped > 0) {
                sum += trapped
            }
            i++
        }

        return sum
    }
}
