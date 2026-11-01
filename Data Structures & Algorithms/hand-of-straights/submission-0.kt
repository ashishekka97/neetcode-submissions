class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        val count = HashMap<Int, Int>()
        hand.forEach { count[it] = count.getOrDefault(it, 0) + 1 }

        hand.sort()

        for (num in hand) {
            if (count[num]!! > 0) {
                for (i in num until num + groupSize) {
                    if (count.getOrDefault(i, 0) == 0) {
                        return false
                    }
                    count[i] = count[i]!! - 1
                }
            }
        }

        return true
    }
}
