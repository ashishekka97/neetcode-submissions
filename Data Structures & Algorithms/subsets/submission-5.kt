class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, path: MutableList<Int>) {
            if (index == nums.size) {
                result.add(path.toList())
                return
            }

            path.add(nums[index])
            dfs(index + 1, path)

            path.removeLast()
            dfs(index + 1, path)
        }

        dfs(0, mutableListOf())
        return result
    }
}
