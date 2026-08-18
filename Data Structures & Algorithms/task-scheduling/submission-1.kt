class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frequencies = IntArray(26)

        for (task in tasks) {
            frequencies[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(reverseOrder())

        for (freq in frequencies) {
            if (freq > 0) {
                maxHeap.offer(freq)
            }
        }

        val waitList = ArrayDeque<Pair<Int, Int>>()

        var time = 0
        while (maxHeap.isNotEmpty() || waitList.isNotEmpty()) {
            time += 1

            if (maxHeap.isNotEmpty()) {
                val count = maxHeap.poll()

                if (count - 1 > 0) {
                    waitList.addLast(Pair(count - 1, n + time))
                }
            }

            if (waitList.isNotEmpty()) {
                if (waitList.first().second == time) {
                    maxHeap.offer(waitList.removeFirst().first)
                }
            }
        }

        return time
    }
}
