class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = List<MutableList<Int>>(numCourses) { mutableListOf() }
        for ((course, pre) in prerequisites) {
            adj[pre].add(course)
        }

        val state = IntArray(numCourses)

        var index = numCourses - 1
        val order = IntArray(numCourses)

        fun hasCycle(course: Int): Boolean {
            if (state[course] == 1) return true
            if (state[course] == 2) return false

            state[course] = 1
            for (neighbor in adj[course]) {
                if (hasCycle(neighbor)) return true
            }
            state[course] = 2
            order[index--] = course

            return false
        }

        for (i in 0 until numCourses) {
            if (hasCycle(i)) return intArrayOf()
        }

        return order
    }
}
