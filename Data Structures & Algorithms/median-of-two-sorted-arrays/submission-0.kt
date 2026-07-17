class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Always binary search on the smaller array to guarantee O(log(min(m,n)))
        val (a, b) = if (nums1.size <= nums2.size) {
            Pair(nums1, nums2)
        } else {
            Pair(nums2, nums1)
        }

        val total = a.size + b.size
        val half = total / 2

        var lo = 0
        var hi = a.size // Note: a.size, not a.size - 1

        while (lo <= hi) {
            // i and j represent the NUMBER of elements in the left partitions
            val i = lo + (hi - lo) / 2
            val j = half - i

            // Safely fetch left and right edges. 
            // If i is 0, there is no left element in 'a', use MIN_VALUE
            val aLeft = if (i > 0) a[i - 1] else Int.MIN_VALUE
            val aRight = if (i < a.size) a[i] else Int.MAX_VALUE
            
            val bLeft = if (j > 0) b[j - 1] else Int.MIN_VALUE
            val bRight = if (j < b.size) b[j] else Int.MAX_VALUE

            // Correct partition found
            if (aLeft <= bRight && bLeft <= aRight) {
                // If total number of elements is odd
                if (total % 2 != 0) {
                    return minOf(aRight, bRight).toDouble()
                }

                // If total number of elements is even
                return (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0
            } 
            // Partition is too far to the right in 'a', move left
            else if (aLeft > bRight) {
                hi = i - 1
            } 
            // Partition is too far to the left in 'a', move right
            else {
                lo = i + 1
            }
        }

        return 0.0 // Should never be reached given valid input arrays
    }
}