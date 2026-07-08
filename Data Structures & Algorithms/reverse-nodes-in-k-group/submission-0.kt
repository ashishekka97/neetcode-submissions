/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head

        var count = 0
        var ptr = head
        while (ptr != null) {
            count++
            ptr = ptr.next
        }

        if (count < k) return head

        var prev: ListNode? = null
        var curr: ListNode? = head
        for (i in 0 until k) {
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }

        head?.next = reverseKGroup(curr, k)


        return prev
    }
}
