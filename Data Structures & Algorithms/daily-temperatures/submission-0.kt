class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val deque = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until temperatures.size) {
            val t = temperatures[i]
            while (deque.isNotEmpty() && t > deque.last().first) {
                val (_, dInd) = deque.removeLast()
                result[dInd] = i - dInd
            }
            deque.addLast(Pair(t, i))
        }

        return result
    }
}
