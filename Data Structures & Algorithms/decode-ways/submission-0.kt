class Solution {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] == '0') return 0

        var older = 1
        var recent = 1

        for (i in 1 until s.length) {
            var current = 0

            if (s[i] != '0') {
                current += recent
            }

            val last2Digit = (s[i - 1] - '0') * 10 + (s[i] - '0')
            if (last2Digit in 10..26) {
                current += older
            }

            older = recent
            recent = current
        }

        return recent
    }
}
