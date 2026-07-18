class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Counts = IntArray(26)
        val s2Counts = IntArray(26)

        for (ch in s1) {
            s1Counts[ch.asIndex()]++
        }

        var matches = 0

        var start = 0
        for (end in 0 until s2.length) {
            val chIn = s2[end]
            s2Counts[chIn.asIndex()]++


            while (end - start + 1 > s1.length) {
                val chOut = s2[start]
                s2Counts[chOut.asIndex()]--
                start++
            }

            if (end - start + 1 == s1.length && s1Counts.contentEquals(s2Counts)) return true

        }

        return false
    }

    private fun Char.asIndex(): Int {
        return this - 'a'
    }
}
