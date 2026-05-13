package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P111Test {
  private val p111 = P111()

  @Test
  fun nullRoot() {
    assertEquals(0, p111.minDepth(null))
  }

  @Test
  fun singleNode() {
    assertEquals(1, p111.minDepth(fromArray(arrayOf(1))))
  }

  @Test
  fun leetcodeExample1() {
    //     3
    //    / \
    //   9  20
    //      / \
    //     15   7
    // min depth = 2 (3 -> 9)
    assertEquals(2, p111.minDepth(fromArray(arrayOf(3, 9, 20, null, null, 15, 7))))
  }

  @Test
  fun leetcodeExample2() {
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    //          \
    //           6
    // min depth = 5 (only one leaf)
    assertEquals(5, p111.minDepth(fromArray(arrayOf(2, null, 3, null, 4, null, 5, null, 6))))
  }

  @Test
  fun leftSkewed() {
    //   1
    //  /
    // 2
    //  /
    // 3
    assertEquals(3, p111.minDepth(fromArray(arrayOf(1, 2, null, 3))))
  }

  @Test
  fun perfectTwoLevels() {
    //     1
    //    / \
    //   2   3
    assertEquals(2, p111.minDepth(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun unequalDepthLeftShorter() {
    //      1
    //    /   \
    //   2     3
    //  /
    // 4
    // min depth = 2 (1 -> 3)
    assertEquals(2, p111.minDepth(fromArray(arrayOf(1, 2, 3, 4))))
  }

  @Test
  fun unequalDepthRightShorter() {
    //      1
    //    /   \
    //   2     3
    //          \
    //           4
    // min depth = 2 (1 -> 2)
    assertEquals(2, p111.minDepth(fromArray(arrayOf(1, 2, 3, null, null, null, 4))))
  }

  @Test
  fun perfectThreeLevels() {
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    assertEquals(3, p111.minDepth(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))))
  }
}
