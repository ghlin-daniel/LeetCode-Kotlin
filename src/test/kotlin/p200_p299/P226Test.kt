package p200_p299

import ds.TreeNode
import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertEquals

class P226Test {
  private val p226 = P226()

  private fun TreeNode?.toList(): List<Int?> {
    if (this == null) return listOf(null)
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.add(this)
    while (queue.isNotEmpty()) {
      val node = queue.removeFirst()
      if (node == null) {
        result.add(null)
      } else {
        result.add(node.`val`)
        queue.add(node.left)
        queue.add(node.right)
      }
    }
    while (result.lastOrNull() == null) result.removeLast()
    return result
  }

  @Test
  fun nullRoot() {
    assertEquals(null, p226.invertTree(null))
  }

  @Test
  fun singleNode() {
    assertEquals(listOf(1), p226.invertTree(fromArray(arrayOf(1))).toList())
  }

  @Test
  fun leetcodeExample() {
    //     4              4
    //    / \    -->     / \
    //   2   7          7   2
    //  / \ / \        / \ / \
    // 1  3 6  9      9  6 3  1
    val result = p226.invertTree(fromArray(arrayOf(4, 2, 7, 1, 3, 6, 9)))
    assertEquals(listOf(4, 7, 2, 9, 6, 3, 1), result.toList())
  }

  @Test
  fun twoNodes() {
    //   1      1
    //  /   →    \
    // 2           2
    val result = p226.invertTree(fromArray(arrayOf(1, 2)))
    assertEquals(listOf(1, null, 2), result.toList())
  }

  @Test
  fun rightSkewed() {
    // 1   →    1
    //  \      /
    //   2    2
    val result = p226.invertTree(fromArray(arrayOf(1, null, 2)))
    assertEquals(listOf(1, 2), result.toList())
  }
}
