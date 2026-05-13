package p500_p599

import kotlin.test.Test
import kotlin.test.assertEquals

class P590Test {
  private val p590 = P590()

  @Test
  fun nullRoot() {
    assertEquals(emptyList(), p590.postorder(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(1), p590.postorder(Node(1)))
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
    assertEquals(listOf(5, 6, 3, 2, 4, 1), p590.postorder(root))
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
    assertEquals(listOf(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1), p590.postorder(root))
  }

  @Test
  fun linearChain() {
    // 1 -> 2 -> 3 (each node has one child)
    val root = Node(1).apply {
      children = listOf(Node(2).apply { children = listOf(Node(3)) })
    }
    assertEquals(listOf(3, 2, 1), p590.postorder(root))
  }
}
