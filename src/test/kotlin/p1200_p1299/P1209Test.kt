package p1200_p1299

import kotlin.test.Test
import kotlin.test.assertEquals

class P1209Test {
  private val p1209 = P1209()

  @Test
  fun example1() {
    assertEquals("abcd", p1209.removeDuplicates("abcd", 2))
  }

  @Test
  fun example2() {
    assertEquals("aa", p1209.removeDuplicates("deeedbbcccbdaa", 3))
  }

  @Test
  fun example3() {
    assertEquals("ps", p1209.removeDuplicates("pbbcggttciiippooaais", 2))
  }

  @Test
  fun emptyString() {
    assertEquals("", p1209.removeDuplicates("", 2))
  }

  @Test
  fun singleChar() {
    assertEquals("z", p1209.removeDuplicates("z", 3))
  }

  @Test
  fun noRemovals() {
    assertEquals("abc", p1209.removeDuplicates("abc", 2))
  }

  @Test
  fun oneRemovalK2() {
    assertEquals("b", p1209.removeDuplicates("aab", 2))
  }

  @Test
  fun cascadingK2() {
    assertEquals("", p1209.removeDuplicates("aabb", 2))
  }

  @Test
  fun k3TripleAtStart() {
    assertEquals("bc", p1209.removeDuplicates("aaabc", 3))
  }

  @Test
  fun k3RemovesRunsLeavingSingleChar() {
    assertEquals("b", p1209.removeDuplicates("aaabaaa", 3))
  }

  @Test
  fun k2CascadingToEmpty() {
    assertEquals("", p1209.removeDuplicates("abba", 2))
  }
}
