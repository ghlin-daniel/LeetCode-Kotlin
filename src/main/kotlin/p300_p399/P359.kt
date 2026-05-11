package p300_p399

class P359 {
  class Logger() {

    private val map = mutableMapOf<String, Int>()

    /** Time: O(1), Space: O(n) for distinct messages stored in the map */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
      return if (map[message]?.let { timestamp < it + 10 } == true) {
        false
      } else {
        map[message] = timestamp
        true
      }
    }
  }
}
