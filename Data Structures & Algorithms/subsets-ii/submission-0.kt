class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        fun dfs(start: Int, path: MutableList<Int>) {
            result.add(path.toList())

            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) continue

                path.add(nums[i])
                dfs(i + 1, path)
                path.removeLast()
            }
        }

        dfs(0, mutableListOf())
        return result
    }
}
