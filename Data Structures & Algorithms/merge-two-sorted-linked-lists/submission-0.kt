/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2

        val dummy = ListNode(0)
        var temp: ListNode? = dummy

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                temp?.next = l1
                l1 = l1.next
            } else {
                temp?.next = l2
                l2 = l2.next
            }
            temp = temp?.next
        }

        temp?.next = l1 ?: l2
        return dummy.next
    }
}
