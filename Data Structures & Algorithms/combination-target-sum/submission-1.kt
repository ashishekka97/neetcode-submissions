class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, path: MutableList<Int>, total: Int) {
            if (total == target) {
                result.add(path.toList())
                return
            }

            if (index >= nums.size || total > target) {
                return
            }

            // Choose candidate
            path.add(nums[index])
            dfs(index, path, total + nums[index])

            // Do not choose candidate
            path.removeLast()
            dfs(index + 1, path, total)
        }

        dfs(0, mutableListOf(), 0)
        return result
    }
}
