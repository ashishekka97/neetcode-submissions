class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        val mappings = arrayOf(
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        )

        fun dfs(index: Int, path: StringBuilder) {
            if (index == digits.length) {
                result.add(path.toString())
                return
            }

            val digit = digits[index]
            val chars = mappings[digit.digitToInt()]!!

            for (i in chars.indices) {
                path.append(chars[i])
                dfs(index + 1, path)
                path.deleteCharAt(path.length - 1)
            }
        }

        dfs(0, StringBuilder())
        return result
    }
}
