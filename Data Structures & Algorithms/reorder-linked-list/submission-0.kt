/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var fast = head
        var slow = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var right = slow?.next
        slow?.next = null

        var prev: ListNode? = null
        while (right != null) {
            val temp = right.next
            right.next = prev
            prev = right
            right = temp
        }

        right = prev
        var left = head

        while (right != null) {
            val temp1 = left?.next
            val temp2 = right.next

            left?.next = right
            right.next = temp1

            left = temp1
            right = temp2
        }
    }
}
