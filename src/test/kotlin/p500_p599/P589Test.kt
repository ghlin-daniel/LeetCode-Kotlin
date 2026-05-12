package p500_p599

import kotlin.test.Test
import kotlin.test.assertEquals

class P589Test {
  private val p589 = P589()

  @Test
  fun nullRoot() {
    assertEquals(emptyList(), p589.preorder(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(1), p589.preorder(Node(1)))
  }

  @Test
  fun leetcodeExample1() {
    //       1
    //     / | \
    //    3  2  4
    //   / \
    //  5   6
    val root = Node(1).apply {
      children = listOf(
        Node(3).apply { children = listOf(Node(5), Node(6)) },
        Node(2),
        Node(4),
      )
    }
    assertEquals(listOf(1, 3, 5, 6, 2, 4), p589.preorder(root))
  }

  @Test
  fun leetcodeExample2() {
    //          1
    //       /  |  \  \
    //      2   3   4   5
    //         / \  |  / \
    //        6   7 8  9  10
    //            |  \    |
    //           11  12  13
    //            |
    //           14
    val root = Node(1).apply {
      children = listOf(
        Node(2),
        Node(3).apply {
          children = listOf(
            Node(6),
            Node(7).apply { children = listOf(Node(11).apply { children = listOf(Node(14)) }) },
          )
        },
        Node(4).apply { children = listOf(Node(8).apply { children = listOf(Node(12)) }) },
        Node(5).apply {
          children = listOf(
            Node(9).apply { children = listOf(Node(13)) },
            Node(10),
          )
        },
      )
    }
    assertEquals(listOf(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10), p589.preorder(root))
  }

  @Test
  fun linearChain() {
    // 1 -> 2 -> 3 (each node has one child)
    val root = Node(1).apply {
      children = listOf(Node(2).apply { children = listOf(Node(3)) })
    }
    assertEquals(listOf(1, 2, 3), p589.preorder(root))
  }
}
