class Twitter {

    val followerMap: MutableMap<Int, MutableSet<Int>>
    val tweetMap: MutableMap<Int, MutableList<Pair<Int, Int>>>
    var count = 0

    init {
        followerMap = mutableMapOf()
        tweetMap = mutableMapOf()
    }

    fun postTweet(userId: Int, tweetId: Int) {
        tweetMap.getOrPut(userId) { mutableListOf() }.add(Pair(count++, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        followerMap.getOrPut(userId) { mutableSetOf() }.add(userId)

        val maxHeap = PriorityQueue<IntArray>(compareByDescending { it[0] } )
        
        for (foloweeId in followerMap[userId]!!) {
            val tweets = tweetMap[foloweeId]
            if (tweets != null && tweets.isNotEmpty()) {
                val index = tweets.size - 1
                val (count, tweetId) = tweets[index]
                maxHeap.offer(intArrayOf(count, tweetId, foloweeId, index - 1))
            }
        }

        val result = mutableListOf<Int>()
        while (maxHeap.isNotEmpty() && result.size < 10) {
            val (currentCount, tweetId, foloweeId, index) = maxHeap.poll()
            result.add(tweetId)
            
            // If the followee has more older tweets, push the next one into the heap
            if (index >= 0) {
                val tweets = tweetMap[foloweeId]!!
                val (nextCount, nextTweetId) = tweets[index]
                maxHeap.offer(intArrayOf(nextCount, nextTweetId, foloweeId, index - 1))
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        followerMap.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followerMap[followerId]?.remove(followeeId)
    }
}
