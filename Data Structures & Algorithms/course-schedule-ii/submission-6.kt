class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = List<MutableList<Int>>(numCourses) { mutableListOf() }

        val indegree = IntArray(numCourses)

        for ((course, pre) in prerequisites) {
            adj[pre].add(course)
            indegree[course]++
        }

        val queue = ArrayDeque<Int>()

        for (course in 0 until numCourses) {
            if (indegree[course] == 0) {
                queue.addLast(course)
            }
        }

        var courseTaken = 0
        val courseOrder = IntArray(numCourses)
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            courseOrder[courseTaken++] = course

            for (nextCourse in adj[course]) {
                indegree[nextCourse]--
                if (indegree[nextCourse] == 0) {
                    queue.addLast(nextCourse)
                }
            }
        }

        if (courseTaken == numCourses) return courseOrder
        return intArrayOf()
    }
}
