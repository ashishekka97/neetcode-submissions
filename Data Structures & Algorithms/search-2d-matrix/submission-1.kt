class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var lowRow = 0
        var hiRow = matrix.size - 1

        while (lowRow <= hiRow) {
            val midRow = lowRow + (hiRow - lowRow) / 2

            when {
                matrix[midRow][n - 1] < target -> lowRow = midRow + 1
                matrix[midRow][0] > target -> hiRow = midRow - 1
                else -> return binarySearch(matrix[midRow], target)
            }
        }

        return false
    }

    fun binarySearch(nums: IntArray, target: Int): Boolean {
        var low = 0
        var hi = nums.size - 1

        while (low <= hi) {
            val mid = low + (hi - low) / 2

            when {
                nums[mid] < target -> low = mid + 1
                nums[mid] > target -> hi = mid - 1
                else -> return true
            }
        }

        return false
    }
}
