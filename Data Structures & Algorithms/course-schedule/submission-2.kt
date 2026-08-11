class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = List<MutableList<Int>>(numCourses) { mutableListOf() }

        for ((course, pre) in prerequisites) {
            adj[pre].add(course)
        }

        val state = IntArray(numCourses)
        // A course can have 3 states:
        // 0 -> Unvisited (Not touched yet)
        // 1 -> Visiting (in current DFS stack)
        // 2 -> Visited (was already visited in a previous DFS stack)

        fun hasCycle(course: Int): Boolean {
            if (state[course] == 1) return true
            if (state[course] == 2) return false

            state[course] = 1
            for (neighbor in adj[course]) {
                if (hasCycle(neighbor)) return true
            }
            
            state[course] = 2
            return false
        }

        for (i in 0 until numCourses) {
            if (hasCycle(i)) return false
        }

        return true
    }
}
