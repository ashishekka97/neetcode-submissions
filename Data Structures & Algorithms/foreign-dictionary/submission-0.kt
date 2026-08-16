class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val adj = mutableMapOf<Char, MutableSet<Char>>()
        val indegree = mutableMapOf<Char, Int>()

        for (word in words) {
            for (ch in word) {
                adj.putIfAbsent(ch, mutableSetOf())
                indegree.putIfAbsent(ch, 0)
            }
        }

        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]

            if (word1.length > word2.length && word1.startsWith(word2)) {
                return ""
            }

            for (j in 0 until min(word1.length, word2.length)) {
                if (word1[j] != word2[j]) {
                    val u = word1[j]
                    val v = word2[j]

                    if (!adj[u]!!.contains(v)) {
                        adj[u]!!.add(v)
                        indegree[v] = indegree[v]!! + 1
                    }
                    break
                }
            }
        }

        val queue = ArrayDeque<Char>()

        for ((char, count) in indegree) {
            if (count == 0) {
                queue.addLast(char)
            }
        }

        val result = StringBuilder()

        while (queue.isNotEmpty()) {
            val char = queue.removeFirst()
            result.append(char)

            for (neighbor in adj[char]!!) {
                indegree[neighbor] = indegree[neighbor]!! - 1
                if (indegree[neighbor] == 0) {
                    queue.addLast(neighbor)
                }
            }
        }

        if (result.length != indegree.size) return ""
        return result.toString()
    }
}
