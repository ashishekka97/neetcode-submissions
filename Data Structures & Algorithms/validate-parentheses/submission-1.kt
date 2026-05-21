class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (ch in s) {
            when (ch) {
                ')' -> {
                    if (stack.peek() != '(') {
                        return false
                    }
                    stack.pop()
                }

                '}' -> {
                    if (stack.peek() != '{') {
                        return false
                    }
                    stack.pop()
                }

                ']' -> {
                    if (stack.peek() != '[') {
                        return false
                    }
                    stack.pop()
                }

                else -> {
                    stack.push(ch)
                }
            }
        }

        return stack.isEmpty()
    }
}
