class Solution {
    fun isPalindrome(s: String): Boolean {
        val sb = StringBuilder()
        for (ch in s) {
            if (ch.isLetterOrDigit()) {
                sb.append(ch.lowercaseChar())
            }
        }
        
        val str = sb.toString()

        var start = 0
        var end = str.length - 1

        while (start < end) {
            if (str[start] != str[end]) return false
            start++
            end--;
        }

        return true
    }
}
