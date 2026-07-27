class PrefixTree {

    private val root: Node

    init {
        root = Node()
    }

    fun insert(word: String) {
        var curr = root
        for (i in 0 until word.length) {
            val ch = word[i]
            if (curr.children.containsKey(ch)) {
                curr = curr.children[ch]!!
            } else {
                val node = Node()
                curr.children[ch] = node
                curr = node
            }
            if (i == word.length - 1) {
                curr.isComplete = true
            }
        }
    }

    fun search(word: String): Boolean {
        var curr = root
        for (ch in word) {
            if (curr.children.containsKey(ch)) {
                curr = curr.children[ch]!!
            } else {
                return false
            }
        }
        return curr.isComplete
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        for (ch in prefix) {
            if (curr.children.containsKey(ch)) {
                curr = curr.children[ch]!!
            } else {
                return false
            }
        }
        return true
    }
}

data class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var isComplete: Boolean = false
)
