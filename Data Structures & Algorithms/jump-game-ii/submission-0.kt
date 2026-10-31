class Solution {
    fun jump(nums: IntArray): Int {
        var result = 0
        var l = 0
        var r = 0

        while (r < nums.size - 1) {
            var farthest = 0
            for (i in l..r) {
                farthest = maxOf(farthest, i + nums[i])
            }
            l = r + 1
            r = farthest
            result += 1
        }

        return result
    }
}
