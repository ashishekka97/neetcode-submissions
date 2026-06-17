class TimeMap() {

    val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val list = map.getOrDefault(key, emptyList())
        if (list.isEmpty()) return ""
        if (timestamp < list[0].first) return ""

        var start = 0
        var end = list.size - 1
        var result = ""

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (list[mid].first <= timestamp) {
                result = list[mid].second
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return result
    }
}
