class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        candidates.sort()

        fun dfs(index: Int, path: MutableList<Int>, total: Int) {
            if (total == target) {
                result.add(path.toList())
                return
            }

            if (total > target || index == candidates.size) {
                return
            }

            // Include the candidate
            path.add(candidates[index])
            dfs(index + 1, path, total + candidates[index])
            path.removeLast()

            // Exclude the candidate
            var i = index
            while (i + 1 < candidates.size && candidates[i] == candidates[i + 1]) {
                i += 1
            }
            dfs(i + 1, path, total)
        }

        dfs(0, mutableListOf(), 0)

        return result       
    }
}
