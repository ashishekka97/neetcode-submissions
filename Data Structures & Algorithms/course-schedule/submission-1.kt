class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = Array<MutableList<Int>>(numCourses) { mutableListOf() }
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

        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            courseTaken += 1

            for (neighbor in adj[course]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    queue.addLast(neighbor)
                }
            }
        }

        return numCourses == courseTaken
    }
}
