class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = mutableMapOf<Int, MutableList<Int>>()
        for (n in 0 until numCourses) {
            preMap[n] = mutableListOf<Int>()
        }
        for (p in prerequisites) {
            
            preMap[p[0]]!!.add(p[1])
        }

        val visited = mutableSetOf<Int>()

        fun dfs(course: Int): Boolean {
            if (visited.contains(course)) return false

            if (preMap[course]!!.isEmpty()) return true
            visited.add(course)

            for (pre in preMap[course]!!) {
                if (!dfs(pre)) return false
            }

            visited.remove(course)
            preMap[course] = mutableListOf()
            return true
        }

        for (course in 0 until numCourses) {
            if (!dfs(course)) return false
        }

        return true
    }
}
