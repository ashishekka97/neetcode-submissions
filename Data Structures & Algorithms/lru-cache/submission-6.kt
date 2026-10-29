class LRUCache(capacity: Int) {

    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0
    var capacity = 0

    init {
        this.capacity = capacity
    }

    val map = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        if (node != head) {
            removeNode(node)
            addNode(node)
        }

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]

        if (node != null) {
            removeNode(node)
            addNode(node)
            node.value = value
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addNode(newNode)

            if (size > capacity) {
                tail?.let { lru ->
                    removeNode(lru)
                    map.remove(lru.key)
                }
            }
        }
    }

    private fun addNode(node: Node) {
        node.next = head
        head?.prev = node
        node.prev = null
        head = node

        if (tail == null) {
            tail = head
        }
        size++
    }

    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next

        if (prev != null) {
            prev.next = next
        } else {
            head = next
        }

        if (next != null) {
            next.prev = prev
        } else {
            tail = prev
        }
        size--
    }

    data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}
