package p300_p399

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P314Test {
  private val p314 = P314()

  @Test
  fun emptyTree() {
    assertEquals(emptyList(), p314.verticalOrder(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(listOf(1)), p314.verticalOrder(fromArray(arrayOf(1))))
  }

  @Test
  fun leetcodeExample1() {
    // [3,9,20,null,null,15,7]
    //        3
    //       / \
    //      9  20
    //        /  \
    //       15   7
    assertEquals(
      listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)),
      p314.verticalOrder(fromArray(arrayOf(3, 9, 20, null, null, 15, 7))),
    )
  }

  @Test
  fun leetcodeExample2() {
    // [3,9,8,4,0,1,7]
    //          3
    //        /   \
    //       9     8
    //      / \   / \
    //     4   0 1   7
    assertEquals(
      listOf(listOf(4), listOf(9), listOf(3, 0, 1), listOf(8), listOf(7)),
      p314.verticalOrder(fromArray(arrayOf(3, 9, 8, 4, 0, 1, 7))),
    )
  }

  @Test
  fun sameColumnDifferentLevelsUsesBfsOrder() {
    // [1,2,3,4,5,6,7]
    //         1
    //        / \
    //       2   3
    //      / \ / \
    //     4  5 6  7
    assertEquals(
      listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7)),
      p314.verticalOrder(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))),
    )
  }

  @Test
  fun leftSkewed() {
    // [1,2,null,3]
    //   1
    //  /
    // 2
    // /
    // 3
    assertEquals(
      listOf(listOf(3), listOf(2), listOf(1)),
      p314.verticalOrder(fromArray(arrayOf(1, 2, null, 3))),
    )
  }

  @Test
  fun rightSkewed() {
    // [1,null,2,null,3]
    // 1
    //  \
    //   2
    //    \
    //     3
    assertEquals(
      listOf(listOf(1), listOf(2), listOf(3)),
      p314.verticalOrder(fromArray(arrayOf(1, null, 2, null, 3))),
    )
  }

  @Test
  fun zigZagAlternatesBetweenTwoColumns() {
    // [1,2,null,null,3,null,4]
    //     1            col 0
    //    /
    //   2              col -1
    //    \
    //     3            col 0
    //    /
    //   4              col -1
    assertEquals(
      listOf(listOf(2, 4), listOf(1, 3)),
      p314.verticalOrder(fromArray(arrayOf(1, 2, null, null, 3, 4))),
    )
  }
}
