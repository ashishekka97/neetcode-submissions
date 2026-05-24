/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sortedIntervals = intervals.sortedBy { it.start }

        for (i in 1 until sortedIntervals.size) {
            if (sortedIntervals[i - 1].end > sortedIntervals[i].start) return false
        }

        return true
    }
}
