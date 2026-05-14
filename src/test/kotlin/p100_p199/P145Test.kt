package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P145Test {
  private val p145 = P145()

  @Test
  fun nullRoot() {
    assertEquals(emptyList(), p145.postorderTraversal(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(1), p145.postorderTraversal(fromArray(arrayOf(1))))
  }

  @Test
  fun completeBinaryTree() {
    //   1
    //  / \
    // 2   3
    assertEquals(listOf(2, 3, 1), p145.postorderTraversal(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun leetcodeExample() {
    // [1, null, 2, 3]
    // 1
    //  \
    //   2
    //  /
    // 3
    assertEquals(listOf(3, 2, 1), p145.postorderTraversal(fromArray(arrayOf(1, null, 2, 3))))
  }

  @Test
  fun leftSkewed() {
    //   1
    //  /
    // 2
    // /
    // 3
    assertEquals(listOf(3, 2, 1), p145.postorderTraversal(fromArray(arrayOf(1, 2, null, 3))))
  }

  @Test
  fun fullTree() {
    //         1
    //        / \
    //       2   3
    //      / \ / \
    //     4  5 6  7
    assertEquals(listOf(4, 5, 2, 6, 7, 3, 1), p145.postorderTraversal(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))))
  }
}
