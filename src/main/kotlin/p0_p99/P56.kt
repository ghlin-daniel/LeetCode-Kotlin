package p0_p99

import kotlin.math.max

class P56 {
  /** Time: O(n log n), Space: O(n) */
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size < 2) return intervals

    intervals.sortBy { it.first() }

    val result = mutableListOf<IntArray>().apply { add(intervals.first()) }
    for (i in 1..intervals.lastIndex) {
      val next = intervals[i]
      val current = result.last()
      if (next.first() <= current.last()) {
        current[1] = max(next.last(), current.last())
      } else {
        result.add(next)
      }
    }

    return result.toTypedArray()
  }
}
