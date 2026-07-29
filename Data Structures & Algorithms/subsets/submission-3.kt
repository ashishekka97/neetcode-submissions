class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(start: Int, path: MutableList<Int>) {
            result.add(path.toList())

            for (i in start until nums.size) {
                path.add(nums[i])
                dfs(i + 1, path)
                path.removeAt(path.size - 1)
            }
        }

        dfs(0, mutableListOf())
        return result
    }
}
