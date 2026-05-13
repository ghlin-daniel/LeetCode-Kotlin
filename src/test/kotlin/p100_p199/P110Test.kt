package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class P110Test {
  private val p110 = P110()

  @Test
  fun nullRoot() {
    assertTrue(p110.isBalanced(null))
  }

  @Test
  fun singleNode() {
    assertTrue(p110.isBalanced(fromArray(arrayOf(1))))
  }

  @Test
  fun leetcodeExample1() {
    //        3
    //      /   \
    //     9    20
    //          / \
    //         15   7
    assertTrue(p110.isBalanced(fromArray(arrayOf(3, 9, 20, null, null, 15, 7))))
  }

  @Test
  fun leetcodeExample2() {
    //          1
    //        /   \
    //       2     2
    //      / \
    //     3   3
    //    / \
    //   4   4
    assertFalse(p110.isBalanced(fromArray(arrayOf(1, 2, 2, 3, 3, null, null, 4, 4))))
  }

  @Test
  fun perfectTwoLevels() {
    //     1
    //    / \
    //   2   3
    assertTrue(p110.isBalanced(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun leftSkewedThreeLevels() {
    //   1
    //  /
    // 2
    //  /
    // 3
    assertFalse(p110.isBalanced(fromArray(arrayOf(1, 2, null, 3))))
  }

  @Test
  fun oneChildOffByOne() {
    //      1
    //    /   \
    //   2     3
    //  /
    // 4
    // height diff at root = 1, still balanced
    assertTrue(p110.isBalanced(fromArray(arrayOf(1, 2, 3, 4))))
  }

  @Test
  fun unbalancedDeepLeft() {
    //        1
    //      /   \
    //     2     3
    //    /
    //   4
    //  /
    // 5
    assertFalse(p110.isBalanced(fromArray(arrayOf(1, 2, 3, 4, null, null, null, 5))))
  }

  @Test
  fun perfectThreeLevels() {
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    assertTrue(p110.isBalanced(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))))
  }

  @Test
  fun unbalancedAtSubtree() {
    //          1
    //        /   \
    //       2     3
    //      / \
    //     4   5
    //    /
    //   6
    //  /
    // 7
    // subtree rooted at 2 is unbalanced
    assertFalse(p110.isBalanced(fromArray(arrayOf(1, 2, 3, 4, 5, null, null, 6, null, null, null, 7))))
  }
}
