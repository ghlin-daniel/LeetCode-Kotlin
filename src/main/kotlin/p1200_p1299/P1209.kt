package p1200_p1299

import java.util.*

class P1209 {
  /** Time: O(n), Space: O(n) for the stack (n = s.length) */
  fun removeDuplicates(s: String, k: Int): String {
    if (s.length < 3) return s

    val stack = Stack<Pair<Char, Int>>().apply { push(Pair(s.first(), 1)) }
    for (i in 1..s.lastIndex) {
      if (stack.isNotEmpty() && stack.peek().first == s[i]) {
        val top = stack.pop()
        if (top.second < k - 1) {
          stack.push(Pair(s[i], top.second + 1))
        }
      } else {
        stack.push(Pair(s[i], 1))
      }
    }

    return stack.joinToString("") { it.first.toString().repeat(it.second) }
  }
}
