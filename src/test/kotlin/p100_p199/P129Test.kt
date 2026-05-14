package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P129Test {
  private val p129 = P129()

  @Test
  fun nullRoot() {
    assertEquals(0, p129.sumNumbers(null))
  }

  @Test
  fun singleNode() {
    assertEquals(5, p129.sumNumbers(fromArray(arrayOf(5))))
  }

  @Test
  fun leetcodeExample1() {
    //   1
    //  / \
    // 2   3
    // paths: 12 + 13 = 25
    assertEquals(25, p129.sumNumbers(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun leetcodeExample2() {
    //     4
    //    / \
    //   9   0
    //  / \
    // 5   1
    // paths: 495 + 491 + 40 = 1026
    assertEquals(1026, p129.sumNumbers(fromArray(arrayOf(4, 9, 0, 5, 1))))
  }

  @Test
  fun rightSkewed() {
    // 1 -> 2 -> 3  =>  123
    assertEquals(123, p129.sumNumbers(fromArray(arrayOf(1, null, 2, null, 3))))
  }

  @Test
  fun leftOnly() {
    //   1
    //  /
    // 2
    // path: 12
    assertEquals(12, p129.sumNumbers(fromArray(arrayOf(1, 2))))
  }
}
