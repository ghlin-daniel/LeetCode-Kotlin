package p0_p99

import ds.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

class P94Test {
  private val p94 = P94()

  @Test
  fun emptyTree() {
    assertEquals(emptyList(), p94.inorderTraversal(null))
  }

  @Test
  fun singleNode() {
    val root = TreeNode(1)
    assertEquals(listOf(1), p94.inorderTraversal(root))
  }

  @Test
  fun leetcodeSample() {
    val root =
      TreeNode(1).apply {
        right = TreeNode(2).apply { left = TreeNode(3) }
      }
    assertEquals(listOf(1, 3, 2), p94.inorderTraversal(root))
  }

  @Test
  fun leftSkewed() {
    val root =
      TreeNode(1).apply {
        left =
          TreeNode(2).apply {
            left = TreeNode(3)
          }
      }
    assertEquals(listOf(3, 2, 1), p94.inorderTraversal(root))
  }

  @Test
  fun rightSkewed() {
    val root =
      TreeNode(1).apply {
        right =
          TreeNode(2).apply {
            right = TreeNode(3)
          }
      }
    assertEquals(listOf(1, 2, 3), p94.inorderTraversal(root))
  }

  @Test
  fun balancedThreeNodes() {
    val root =
      TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
      }
    assertEquals(listOf(2, 1, 3), p94.inorderTraversal(root))
  }
}
