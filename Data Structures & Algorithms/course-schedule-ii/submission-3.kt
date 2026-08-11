class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = List<MutableList<Int>>(numCourses) { mutableListOf() }
        val indegree = IntArray(numCourses)

        for ((course, pre) in prerequisites) {
            adj[pre].add(course)
            indegree[course]++
        }

        val queue = ArrayDeque<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                queue.addLast(i)
            }
        }

        var courseTaken = 0
        val order = IntArray(numCourses)

        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            order[courseTaken++] = course

            for (neighbor in adj[course]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    queue.addLast(neighbor)
                }
            }
        }

        if (courseTaken == numCourses) return order
        return intArrayOf()
    }
}
