class Solution {

    val trie: Trie

    init {
        trie = Trie()
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        for (i in words.indices) {
            trie.insertWord(words[i], i)
        }

        val result = mutableSetOf<String>()

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun dfs(row: Int, col: Int, node: TrieNode) {
            val ch = board[row][col]

            if (!node.children.containsKey(ch)) {
                return
            }
            val nextNode = node.children[ch]!!

            if (nextNode.wordIndex != -1) {
                result.add(words[nextNode.wordIndex])
            }

            board[row][col] = '#'

            for (dir in directions) {
                val newCol = col + dir[0]
                val newRow = row + dir[1]

                if (newRow >= 0 && newRow < board.size && newCol >= 0 && newCol < board[0].size) {
                    if (board[newRow][newCol] != '#') {
                        dfs(newRow, newCol, nextNode)
                    }
                }
            }
            board[row][col] = ch
        }

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                dfs(i, j, trie.root)
            }
        }

        return result.toList()
    }
}

class Trie {

    val root: TrieNode

    init {
        root = TrieNode()
    }

    fun insertWord(word: String, index: Int) {
        var curr = root
        for (ch in word) {
            curr = curr.children.getOrPut(ch) { TrieNode() }
        }
        curr.wordIndex = index
    }

}

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var wordIndex: Int = -1
)