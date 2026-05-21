class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for (str in strs) {
            sb.append("${str.length}#${str}")
        }

        return sb.toString()
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            var j = i
            while (str[j] != '#') {
                j++
            }
            val length = str.substring(i, j).toInt()
            i = j + 1
            val text = str.substring(i, i + length)
            res.add(text)
            i += length
        }

        return res
    }
}
