class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun backtrack(index: Int) {
            // Base case
            if (index == nums.size) {
                result.add(path.toList())
                return
            }

            // Include this letter
            path.add(nums[index])
            backtrack(index + 1)

            // Exclude this letter
            path.removeLast()
            backtrack(index + 1)
        }

        backtrack(0)
        return result
    }
}
