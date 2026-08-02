class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, path: MutableList<Int>, total: Int, target: Int) {
            if (total == target) {
                result.add(path.toList())
                return
            }

            if (total > target || index >= nums.size) {
                return
            }

            path.add(nums[index])
            dfs(index, path, total + nums[index], target)

            path.removeLast()
            dfs(index + 1, path, total, target)
        }

        dfs(0, mutableListOf(), 0, target)
        return result
    }
}
