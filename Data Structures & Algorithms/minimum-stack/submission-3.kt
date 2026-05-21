class MinStack() {

    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || minStack.peek() >= `val`) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop()
        }
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
