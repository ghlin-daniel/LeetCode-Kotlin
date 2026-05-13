package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class P100Test {
  private val p100 = P100()

  @Test
  fun bothNull() {
    assertTrue(p100.isSameTree(null, null))
  }

  @Test
  fun oneNull() {
    assertFalse(p100.isSameTree(fromArray(arrayOf(1)), null))
    assertFalse(p100.isSameTree(null, fromArray(arrayOf(1))))
  }

  @Test
  fun singleNodeEqual() {
    assertTrue(p100.isSameTree(fromArray(arrayOf(1)), fromArray(arrayOf(1))))
  }

  @Test
  fun singleNodeDifferentValue() {
    assertFalse(p100.isSameTree(fromArray(arrayOf(1)), fromArray(arrayOf(2))))
  }

  @Test
  fun leetcodeExample1() {
    //   1      1
    //  / \    / \
    // 2   3  2   3
    assertTrue(
      p100.isSameTree(fromArray(arrayOf(1, 2, 3)), fromArray(arrayOf(1, 2, 3)))
    )
  }

  @Test
  fun leetcodeExample2() {
    // 1      1
    //  \    /
    //   2  2
    assertFalse(
      p100.isSameTree(fromArray(arrayOf(1, null, 2)), fromArray(arrayOf(1, 2)))
    )
  }

  @Test
  fun leetcodeExample3() {
    //   1      1
    //  / \    / \
    // 2   1  1   2
    assertFalse(
      p100.isSameTree(fromArray(arrayOf(1, 2, 1)), fromArray(arrayOf(1, 1, 2)))
    )
  }

  @Test
  fun differentDepths() {
    //   1      1
    //  /      / \
    // 2      2   3
    assertFalse(
      p100.isSameTree(fromArray(arrayOf(1, 2)), fromArray(arrayOf(1, 2, 3)))
    )
  }

  @Test
  fun deepEqual() {
    //       1              1
    //      / \            / \
    //     2   3          2   3
    //    / \            / \
    //   4   5          4   5
    assertTrue(
      p100.isSameTree(
        fromArray(arrayOf(1, 2, 3, 4, 5)),
        fromArray(arrayOf(1, 2, 3, 4, 5))
      )
    )
  }
}
