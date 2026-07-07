/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val listMap = mutableMapOf<Node, Node>()

        var curr = head
        while (curr != null) {
            val copy = Node(curr.`val`)
            listMap[curr] = copy
            curr = curr.next
        }

        curr = head
        while (curr != null) {
            val copy = listMap[curr]
            copy?.next = listMap[curr.next]
            copy?.random = listMap[curr.random]
            curr = curr.next
        }

        return listMap[head]
    }
}
