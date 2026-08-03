class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val used = BooleanArray(nums.size)

        fun dfs(path: MutableList<Int>) {
            if (path.size == nums.size) {
                result.add(path.toList())
                return
            }

            for (i in nums.indices) {
                if (used[i]) continue

                used[i] = true
                path.add(nums[i])
                dfs(path)
                path.removeLast()
                used[i] = false
            }
        }

        dfs(mutableListOf())
        return result
    }
}
