class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val merged = mutableListOf(intervals[0])
        for (i in 1 until intervals.size) {
            val curr = intervals[i]
            val prev = merged.last()

            if (curr[0] <= prev[1]) {
                prev[1] = maxOf(prev[1], curr[1])
            } else {
                merged.add(curr)
            }
        }

        return merged.toTypedArray()
    }
}
