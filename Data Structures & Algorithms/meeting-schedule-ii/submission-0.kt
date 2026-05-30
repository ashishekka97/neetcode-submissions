/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val starts = intervals.map { it.start }.sorted()
        val ends = intervals.map { it.end }.sorted()
        var s = 0
        var e = 0
        var rooms = 0
        var maxRooms = 0

        while (s < starts.size) {
            if (starts[s] < ends[e]) {
                rooms++
                s++
                maxRooms = maxOf(maxRooms, rooms)
            } else {
                rooms--
                e++
            }
        }

        return maxRooms
    }
}
