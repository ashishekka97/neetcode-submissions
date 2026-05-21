class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val deque = ArrayDeque<Int>()
        for (token in tokens) {
            when {
                isOperator(token) -> {
                    val b = deque.removeLast()
                    val a = deque.removeLast()

                    val result = performOperation(a, b, token)
                    deque.addLast(result)
                }

                else -> {
                    val num = token.toIntOrNull()
                    if (num != null) {
                        deque.addLast(num)
                    }
                }
            }
        }

        if (deque.isEmpty() || deque.size > 1) throw IllegalArgumentException("Arguments Invalid")

        return deque.removeLast()
    }

    private fun isOperator(token: String): Boolean {
        return token in listOf("+", "-", "*", "/")
    }

    private fun performOperation(a: Int, b: Int, operator: String): Int {
        if (!isOperator(operator)) throw IllegalArgumentException("Arguments Invalid")

        return when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> a / b
        }
    }
}
