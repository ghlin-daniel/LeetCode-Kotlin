package p100_p199

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P144Test {
  private val p144 = P144()

  @Test
  fun nullRoot() {
    assertEquals(emptyList(), p144.preorderTraversal(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(1), p144.preorderTraversal(fromArray(arrayOf(1))))
  }

  @Test
  fun completeBinaryTree() {
    //   1
    //  / \
    // 2   3
    assertEquals(listOf(1, 2, 3), p144.preorderTraversal(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun leetcodeExample() {
    // [1, null, 2, 3]
    // 1
    //  \
    //   2
    //  /
    // 3
    assertEquals(listOf(1, 2, 3), p144.preorderTraversal(fromArray(arrayOf(1, null, 2, 3))))
  }

  @Test
  fun leftSkewed() {
    // [1, 2, null, 3]
    //   1
    //  /
    // 2
    // /
    // 3
    assertEquals(listOf(1, 2, 3), p144.preorderTraversal(fromArray(arrayOf(1, 2, null, 3))))
  }

  @Test
  fun fullTree() {
    // [1,2,3,4,5,6,7]
    //         1
    //        / \
    //       2   3
    //      / \ / \
    //     4  5 6  7
    assertEquals(listOf(1, 2, 4, 5, 3, 6, 7), p144.preorderTraversal(fromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))))
  }
}
