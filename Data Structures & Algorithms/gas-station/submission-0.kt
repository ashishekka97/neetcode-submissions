class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        var totalTank = 0
        var currentTank = 0
        var startStation = 0

        for (i in 0 until gas.size) {
            val netGain = gas[i] - cost[i]
            currentTank += netGain
            totalTank += netGain

            if (currentTank < 0) {
                startStation = i + 1
                currentTank = 0
            }
        }

        if (totalTank >= 0) return startStation
        return -1
    }
}
