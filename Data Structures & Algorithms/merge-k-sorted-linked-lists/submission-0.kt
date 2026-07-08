/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var listsCopy = lists

        while (listsCopy.size > 1) {
            val mergedLists = mutableListOf<ListNode?>()

            for (i in 0 until listsCopy.size step 2) {
                val l1 = listsCopy[i]
                val l2 = if (i + 1 < listsCopy.size) listsCopy[i + 1] else null
                mergedLists.add(mergeLists(l1, l2))
            }

            listsCopy = mergedLists.toTypedArray()
        }

        return listsCopy[0]
    }

    private fun mergeLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2

        val dummy = ListNode(0)
        var curr: ListNode? = dummy

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                curr?.next = p1
                p1 = p1.next
            } else {
                curr?.next = p2
                p2 = p2.next
            }
            curr = curr?.next
        }

        curr?.next = p1 ?: p2
        return dummy.next
    }
}
