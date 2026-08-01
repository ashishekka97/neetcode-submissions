class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()

        val keyMap = listOf(
            "",
            "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        )

        fun backtrack(index: Int, path: StringBuilder) {
            if (index == digits.length) {
                result.add(path.toString())
                return
            }

            val digit = digits[index].digitToInt()
            val chars = keyMap[digit]

            for (char in chars) {
                path.append(char)
                backtrack(index + 1, path)
                path.deleteCharAt(path.lastIndex)
            }
        }

        if (digits.length > 0) {
            backtrack(0, StringBuilder())
        }

        return result
    }
}
