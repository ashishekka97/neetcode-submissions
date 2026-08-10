class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preMap = List<MutableList<Int>>(numCourses) { mutableListOf<Int>() }

        for (i in 0 until prerequisites.size) {
            val (course, preReq) = prerequisites[i]
            preMap[course].add(preReq)
        }

        val tempVisit = mutableSetOf<Int>()
        val permVisit = mutableSetOf<Int>()
        val output = mutableListOf<Int>()

        fun dfs(course: Int): Boolean {
            if (tempVisit.contains(course)) return false
            if (permVisit.contains(course)) return true

            tempVisit.add(course)
            for (pre in preMap[course]) {
                if (!dfs(pre)) return false
            }
            tempVisit.remove(course)
            permVisit.add(course)
            output.add(course)
            return true
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return intArrayOf()
        }

        return output.toIntArray()
    }
}
