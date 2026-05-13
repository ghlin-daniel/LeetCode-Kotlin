package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P104Test {
  private val p104 = P104()

  @Test
  fun nullRoot() {
    assertEquals(0, p104.maxDepth(null))
  }

  @Test
  fun singleNode() {
    assertEquals(1, p104.maxDepth(fromArray(arrayOf(1))))
  }

  @Test
  fun leetcodeExample1() {
    //     3
    //    / \
    //   9  20
    //      / \
    //     15   7
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(3, 9, 20, null, null, 15, 7))))
  }

  @Test
  fun leetcodeExample2() {
    //   1
    //    \
    //     2
    assertEquals(2, p104.maxDepth(fromArray(arrayOf(1, null, 2))))
  }

  @Test
  fun leftSkewed() {
    //   1
    //  /
    // 2
    //  /
    // 3
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(1, 2, null, 3))))
  }

  @Test
  fun rightSkewed() {
    //   1
    //    \
    //     2
    //      \
    //       3
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(1, null, 2, null, 3))))
  }

  @Test
  fun perfectTwoLevels() {
    //     1
    //    / \
    //   2   3
    assertEquals(2, p104.maxDepth(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun unequalDepthLeftDeeper() {
    //      1
    //    /   \
    //   2     3
    //  /
    // 4
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(1, 2, 3, 4))))
  }

  @Test
  fun unequalDepthRightDeeper() {
    //      1
    //    /   \
    //   2     3
    //          \
    //           4
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(1, 2, 3, null, null, null, 4))))
  }

  @Test
  fun perfectThreeLevels() {
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    assertEquals(3, p104.maxDepth(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))))
  }
}
