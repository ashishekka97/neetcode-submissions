class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val result = IntArray(temperatures.size)
        val stack = mutableListOf<Pair<Int, Int>>()

        for (i in temperatures.indices) {
            val temp = temperatures[i]
            var start = i
            while (stack.isNotEmpty() && stack.last().first < temp) {
                val (t, index) = stack.removeLast()
                result[index] = i - index
            }
            stack.addLast(Pair(temp, start))
        }

        return result
    }
}
