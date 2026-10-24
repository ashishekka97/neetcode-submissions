class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) {
            return intArrayOf(1)
        }

        if (digits[digits.size - 1] < 9) {
            digits[digits.size - 1]++
            return digits
        } else {
            return plusOne(digits.copyOfRange(0, digits.size - 1)) + intArrayOf(0)
        }
    }
}
