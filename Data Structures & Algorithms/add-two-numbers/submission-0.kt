/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy: ListNode = ListNode(0)
        var curr: ListNode? = dummy

        var p1 = l1
        var p2 = l2
        var carry = 0

        while (p1 != null && p2 != null) {
            val sum = p1.`val` + p2.`val` + carry
            val new = ListNode(sum % 10)
            carry = sum / 10
            curr?.next = new
            curr = curr?.next
            p1 = p1.next
            p2 = p2.next
        }

        while (p1 != null) {
            val sum = p1.`val` + carry
            val new = ListNode(sum % 10)
            carry = sum / 10
            curr?.next = new
            curr = curr?.next
            p1 = p1.next
        }

        while (p2 != null) {
            val sum = p2.`val` + carry
            val new = ListNode(sum % 10)
            carry = sum / 10
            curr?.next = new
            curr = curr?.next
            p2 = p2.next
        }

        if (carry > 0) {
            val new = ListNode(carry)
            curr?.next = new
            curr = curr?.next
        }

        return dummy.next
    }
}
