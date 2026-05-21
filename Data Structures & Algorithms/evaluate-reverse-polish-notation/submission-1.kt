class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val deque = ArrayDeque<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> {
                    val b = deque.removeLast()
                    val a = deque.removeLast()
                    deque.addLast(a + b)
                }
                "-" -> {
                    val b = deque.removeLast()
                    val a = deque.removeLast()
                    deque.addLast(a - b)
                }
                "*" -> {
                    val b = deque.removeLast()
                    val a = deque.removeLast()
                    deque.addLast(a * b)
                }
                "/" -> {
                    val b = deque.removeLast()
                    val a = deque.removeLast()
                    deque.addLast(a / b)
                }
                else -> {
                    deque.addLast(token.toInt())
                }
            }
        }

        return deque.removeLast()
    }
}
