class Solution {
    fun isValid(s: String): Boolean {
        val deque = ArrayDeque<Char>()
        for (ch in s) {
            when (ch) {
                '(', '{', '[' -> {
                    deque.push(ch)
                }
                ')' -> {
                    if (deque.peek() != '(') return false
                    deque.pop()
                }
                '}' -> {
                    if (deque.peek() != '{') return false
                    deque.pop()
                }
                ']' -> {
                    if (deque.peek() != '[') return false
                    deque.pop()
                }
            }
        }

        return deque.isEmpty()
    }
}
