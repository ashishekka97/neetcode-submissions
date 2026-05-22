class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for (i in temperatures.indices) {
            val temp = temperatures[i]
            while (stack.isNotEmpty() && temperatures[stack.peek()] < temp) {
                val popped = stack.pop()
                result[popped] = i - popped
            }
            stack.push(i)
        }

        return result
    }
}
