class WordDictionary {

    private val root: Node

    init {
        root = Node()
    }

    fun addWord(word: String) {
        var curr = root
        for (ch in word) {
            curr = curr.children.getOrPut(ch) { Node() } 
        }
        curr.isComplete = true
    }

    fun search(word: String): Boolean {

        fun search(startIndex: Int, startNode: Node): Boolean {
            var curr = startNode
            for (i in startIndex until word.length) {
                val ch = word[i]
                if (ch != '.') {
                    curr = curr.children[ch] ?: return false
                } else {
                    for (child in curr.children.values) {
                        if (search(i + 1, child)) return true
                    }
                    return false
                }
            }
            return curr.isComplete
        }
        return search(0, root)
    }
}

data class Node(
    var isComplete: Boolean = false,
    val children: MutableMap<Char, Node> = mutableMapOf<Char, Node>()
)
