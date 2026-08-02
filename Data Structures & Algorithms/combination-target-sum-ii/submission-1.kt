class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        candidates.sort()

        fun dfs(index: Int, path: MutableList<Int>, total: Int, target: Int) {
            if (total == target) {
                result.add(path.toList())
                return
            }

            if (total > target || index == candidates.size) {
                return
            }

            // Take the candidate at current index
            path.add(candidates[index])
            dfs(index + 1, path, total + candidates[index], target)
            path.removeLast()

            // Do not take candidate at current index
            // Ensure that we skip dupes as well
            var i = index
            while (i + 1 < candidates.size && candidates[i] == candidates[i + 1]) {
                i += 1
            }
            dfs(i + 1, path, total, target)
        }

        dfs(0, mutableListOf(), 0, target)
        return result
    }
}
