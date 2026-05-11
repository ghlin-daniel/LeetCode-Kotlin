package p1000_1099

import java.util.*

class P1047 {
  /** Time: O(n), Space: O(n) */
  fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    s.forEach {
      if (stack.isNotEmpty() && stack.peek() == it) {
        stack.pop()
      } else {
        stack.push(it)
      }
    }
    return stack.joinToString("")
  }
}
