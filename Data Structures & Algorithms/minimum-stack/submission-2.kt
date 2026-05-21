class MinStack() {

    val mainStack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        mainStack.addLast(`val`)
        if (minStack.isEmpty() || minStack.last() >= `val`) {
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        if (mainStack.last() == minStack.last()) {
            minStack.removeLast()
        }
        mainStack.removeLast()
    }

    fun top(): Int {
        return mainStack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
