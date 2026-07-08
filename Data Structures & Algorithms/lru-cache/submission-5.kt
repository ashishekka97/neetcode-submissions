class LRUCache(val capacity: Int) {

    var head: Node? = null
    var tail: Node? = null
    var numOfNodes: Int = 0

    val map = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        if (head != node) {
            removeNode(node)
            addNode(node)
        }

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]

        if (node != null) {
            if (node != head) {
                removeNode(node)
                addNode(node)
            }
            node.value = value
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addNode(newNode)
            numOfNodes++

            if (numOfNodes > capacity) {
                tail?.let { lru ->
                    map.remove(lru.key)
                    removeNode(lru)
                    numOfNodes--
                }
            }
        }
    }

    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next

        if (prev != null) prev.next = next else head = next
        if (next != null) next.prev = prev else tail = prev
    }

    private fun addNode(node: Node) {
        node.next = head
        node.prev = null
        head?.prev = node
        head = node

        if (tail == null) tail = head
    }

    data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}
