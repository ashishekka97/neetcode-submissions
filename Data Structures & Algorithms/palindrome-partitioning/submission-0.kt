class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()

        fun dfs(start: Int, path: MutableList<String>) {
            if (start >= s.length) {
                result.add(path.toList())
                return
            }

            for (end in start until s.length) {
                if (isPalindrome(s, start, end)) {
                    path.add(s.substring(start, end + 1))
                    dfs(end + 1, path)
                    path.removeLast()
                }
            }
        }

        dfs(0, mutableListOf())
        return result
    }

    fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        var l =  left
        var r = right

        while (l < r) {
            if (s[l] != s[r]) return false
            l++
            r--
        }

        return true
    }
}
