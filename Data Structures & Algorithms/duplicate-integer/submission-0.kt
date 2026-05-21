class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val appeared = mutableSetOf<Int>()

        nums.forEach { num ->
            if (appeared.contains(num)) return true
            appeared.add(num)
        }

        return false;
    }
}
