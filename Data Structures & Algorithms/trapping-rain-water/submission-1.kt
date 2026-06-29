class Solution {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var left = 0
        var right = height.size - 1

        var leftMax = height[left]
        var rightMax = height[right]

        var count = 0

        while (left < right) {
            if (leftMax < rightMax) {
                left += 1
                if (height[left] > leftMax) {
                    leftMax = height[left]
                } else {
                    count += (leftMax - height[left])
                }
            } else {
                right -= 1
                if (height[right] > rightMax) {
                    rightMax = height[right]
                } else {
                    count += (rightMax - height[right])
                }
            }
        }

        return count
    }
}
