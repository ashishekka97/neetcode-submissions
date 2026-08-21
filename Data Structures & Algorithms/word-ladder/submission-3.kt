class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if (endWord !in wordList) return 0

        wordList.add(beginWord)

        val adj = mutableMapOf<String, MutableList<String>>()

        for (word in wordList) {
            for (i in 0 until word.length) {
                val pattern = generatePattern(word, i)
                adj.getOrPut(pattern) { mutableListOf() }.add(word)
            }
        }

        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<String>()
        queue.addLast(beginWord)

        var steps = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val word = queue.removeFirst()

                if (word == endWord) return steps

                for (i in 0 until word.length) {
                    val pattern = generatePattern(word, i)
                    val nextWords = adj[pattern] ?: continue

                    for (nextWord in nextWords) {
                        if (nextWord !in visited) {
                            visited.add(word)
                            queue.addLast(nextWord)
                        }
                    }
                }
            }
            steps++
        }

        return 0
    }

    fun generatePattern(word: String, i: Int): String {
        return word.substring(0, i) + "*" + word.substring(i + 1)
    }
}
