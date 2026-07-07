class LRUCache(val capacity: Int) {

    var nodeCount = 0
    var head: Node? = null
    var tail: Node? = null
    val map = mutableMapOf<Int, Node>()


    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        if (node != head) {
            removeNode(node)
            addToHead(node)
        }

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]

        if (node != null) {
            node.value = value
            removeNode(node)
            addToHead(node)
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addToHead(newNode)
            nodeCount += 1

            // Eviction
            if (nodeCount > capacity) {
                tail?.let { lru ->
                    map.remove(lru.key)
                    removeNode(lru)
                    nodeCount -= 1
                }
            }
        }
    }

    /**
        Removes the given node.
        If prev is null, that means node was head, therefore next is new head
        If next is null, that mean node was tail, therefore prev is new tail
    **/
    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next

        if (prev != null) prev.next = next else head = next
        if (next != null) next.prev = prev else tail = prev
    }

    /**
        Add a given node to the head.
        If there was no tail (empty LL), the head becomes the tail
    **/
    private fun addToHead(node: Node) {
        val currHead = head

        currHead?.prev = node
        node.next = currHead
        node.prev = null
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
