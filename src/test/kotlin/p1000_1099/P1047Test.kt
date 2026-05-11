package p1000_1099

import kotlin.test.Test
import kotlin.test.assertEquals

class P1047Test {
  private val p1047 = P1047()

  @Test
  fun example1() {
    assertEquals("ca", p1047.removeDuplicates("abbaca"))
  }

  @Test
  fun emptyString() {
    assertEquals("", p1047.removeDuplicates(""))
  }

  @Test
  fun singleChar() {
    assertEquals("z", p1047.removeDuplicates("z"))
  }

  @Test
  fun noAdjacentDuplicates() {
    assertEquals("abc", p1047.removeDuplicates("abc"))
  }

  @Test
  fun pairRemovesToEmpty() {
    assertEquals("", p1047.removeDuplicates("aa"))
  }

  @Test
  fun leadingPairRemoved() {
    assertEquals("b", p1047.removeDuplicates("aab"))
  }

  @Test
  fun cascadingRemovals() {
    assertEquals("", p1047.removeDuplicates("abba"))
  }

  @Test
  fun multiplePassesImplicitly() {
    assertEquals("ay", p1047.removeDuplicates("azxxzy"))
  }
}
