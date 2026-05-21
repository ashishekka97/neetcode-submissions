class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val alphabetMap = mutableMapOf<Char, Int>()

        s.forEach { char ->
            val count = alphabetMap.getOrPut(char) { 0 }
            alphabetMap[char] = count + 1
        }
        t.forEach { char ->
            val count = alphabetMap[char] ?: 0
            if (count == 0) return false
            if (count - 1 == 0) alphabetMap.remove(char)
            else alphabetMap[char] = count - 1
        }

        if (!alphabetMap.isEmpty()) return false

        return true;
    }
}
