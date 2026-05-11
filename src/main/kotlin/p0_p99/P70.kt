package p0_p99

class P70 {
  /** Time: O(n), Space: O(1) */
  fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    var first = 1
    var second = 2
    for (i in 3..n) {
      val next = first + second
      first = second
      second = next
    }
    return second
  }
}
