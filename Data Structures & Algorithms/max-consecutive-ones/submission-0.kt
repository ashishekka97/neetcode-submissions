class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0;

        var count = 0;
        nums.forEach { num ->
            if (num == 1) {
                count += 1
            } else {
                max = Math.max(count, max);
                count = 0
            }
        }
        max = Math.max(count, max);

        return max
    }
}
