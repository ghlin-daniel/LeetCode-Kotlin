package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P102Test {
  private val p102 = P102()

  @Test
  fun nullRoot() {
    assertEquals(emptyList(), p102.levelOrder(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(listOf(1)), p102.levelOrder(fromArray(arrayOf(1))))
  }

  @Test
  fun leetcodeExample1() {
    //     3
    //    / \
    //   9  20
    //      / \
    //     15   7
    assertEquals(
      listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
      p102.levelOrder(fromArray(arrayOf(3, 9, 20, null, null, 15, 7)))
    )
  }

  @Test
  fun perfectTwoLevels() {
    //     1
    //    / \
    //   2   3
    assertEquals(
      listOf(listOf(1), listOf(2, 3)),
      p102.levelOrder(fromArray(arrayOf(1, 2, 3)))
    )
  }

  @Test
  fun leftSkewed() {
    //   1
    //  /
    // 2
    //  \
    //   3  (not valid leftskew but tests sparse tree)
    // Actually a true left-skewed tree:
    //   1
    //  /
    // 2
    ///
    // 3
    assertEquals(
      listOf(listOf(1), listOf(2), listOf(3)),
      p102.levelOrder(fromArray(arrayOf(1, 2, null, 3)))
    )
  }

  @Test
  fun rightSkewed() {
    //   1
    //    \
    //     2
    //      \
    //       3
    assertEquals(
      listOf(listOf(1), listOf(2), listOf(3)),
      p102.levelOrder(fromArray(arrayOf(1, null, 2, null, 3)))
    )
  }

  @Test
  fun perfectThreeLevels() {
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    assertEquals(
      listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6, 7)),
      p102.levelOrder(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7)))
    )
  }

  @Test
  fun sparseTree() {
    //      1
    //    /   \
    //   2     3
    //  /         \
    // 4            5
    assertEquals(
      listOf(listOf(1), listOf(2, 3), listOf(4, 5)),
      p102.levelOrder(fromArray(arrayOf(1, 2, 3, 4, null, null, 5)))
    )
  }
}
