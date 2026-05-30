class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }

        var currentEnd = intervals[0][1]
        var count = 0

        for (i in 1 until intervals.size) {
            if (intervals[i][0] < currentEnd) {
                count++
            } else {
                currentEnd = maxOf(currentEnd, intervals[i][1])
            }
        }

        return count
    }
}
