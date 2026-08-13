class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if (endWord !in wordList) return 0

        val adj = mutableMapOf<String, MutableList<String>>()
        wordList.add(beginWord)

        for (word in wordList) {
            for (i in 0 until word.length) {
                val pattern = generatePattern(word, i)
                adj.getOrPut(pattern) { mutableListOf() }.add(word)
            }
        }

        val visited = mutableSetOf(beginWord)
        val queue = ArrayDeque<String>()
        queue.addLast(beginWord)

        var result = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val word = queue.removeFirst()
                if (word == endWord) return result

                for (i in 0 until word.length) {
                    val pattern = generatePattern(word, i)
                    if (adj.containsKey(pattern)) {
                        for (neighbor in adj[pattern]!!) {
                            if (neighbor !in visited) {
                                visited.add(neighbor)
                                queue.addLast(neighbor)
                            }
                        }
                    }
                }
            }
            result += 1
        }

        return 0
    }

    fun generatePattern(word: String, wildCardIndex: Int): String {
        return word.substring(0, wildCardIndex)+ "*" + word.substring(wildCardIndex + 1)
    }
}
