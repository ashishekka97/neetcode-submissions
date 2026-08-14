class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counts = IntArray(26)
        for (task in tasks) {
            counts[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (count in counts) {
            if (count > 0) {
                maxHeap.offer(count)
            }
        }

        val queue = ArrayDeque<IntArray>()

        var time = 0

        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            time += 1

            if (maxHeap.isNotEmpty()) {
                val count = maxHeap.poll() - 1
                if (count > 0) {
                    queue.addLast(intArrayOf(count, time + n))
                }
            }

            if (queue.isNotEmpty() && queue.first()[1] == time) {
                val count = queue.removeFirst()[0]
                maxHeap.offer(count)
            }
        }

        return time
    }
}
