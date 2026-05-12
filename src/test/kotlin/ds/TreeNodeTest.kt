package ds

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TreeNodeTest {

  // ── fromArray ──────────────────────────────────────────────────────────────

  @Test
  fun fromArrayEmpty() {
    assertNull(fromArray(emptyArray()))
  }

  @Test
  fun fromArrayNullRoot() {
    assertNull(fromArray(arrayOf(null)))
  }

  @Test
  fun fromArraySingleNode() {
    val root = fromArray(arrayOf(1))!!
    assertEquals(1, root.`val`)
    assertNull(root.left)
    assertNull(root.right)
  }

  @Test
  fun fromArrayCompleteBinaryTree() {
    //   1
    //  / \
    // 2   3
    val root = fromArray(arrayOf(1, 2, 3))!!
    assertEquals(1, root.`val`)
    assertEquals(2, root.left?.`val`)
    assertEquals(3, root.right?.`val`)
  }

  @Test
  fun fromArrayWithNulls() {
    // [3, 9, 20, null, null, 15, 7]
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    val root = fromArray(arrayOf(3, 9, 20, null, null, 15, 7))!!
    assertEquals(3, root.`val`)
    assertEquals(9, root.left?.`val`)
    assertNull(root.left?.left)
    assertNull(root.left?.right)
    assertEquals(20, root.right?.`val`)
    assertEquals(15, root.right?.left?.`val`)
    assertEquals(7, root.right?.right?.`val`)
  }

  @Test
  fun fromArrayLeafBeforeInternalAtSameLevel() {
    // [1, 2, 3, null, null, 4, 5]: node 2 is a leaf while node 3 has children
    //     1
    //    / \
    //   2   3
    //      / \
    //     4   5
    val root = fromArray(arrayOf(1, 2, 3, null, null, 4, 5))!!
    assertEquals(2, root.left?.`val`)
    assertNull(root.left?.left)
    assertNull(root.left?.right)
    assertEquals(3, root.right?.`val`)
    assertEquals(4, root.right?.left?.`val`)
    assertEquals(5, root.right?.right?.`val`)
  }

  @Test
  fun fromArrayLeftSkewed() {
    // [1, 2, null, 3]
    //   1
    //  /
    // 2
    // /
    // 3
    val root = fromArray(arrayOf(1, 2, null, 3))!!
    assertEquals(2, root.left?.`val`)
    assertNull(root.right)
    assertEquals(3, root.left?.left?.`val`)
    assertNull(root.left?.right)
  }

  // ── toArray ────────────────────────────────────────────────────────────────

  @Test
  fun toArrayNull() {
    assertContentEquals(emptyArray<Int?>(), toArray(null))
  }

  @Test
  fun toArraySingleNode() {
    assertContentEquals(arrayOf(1), toArray(TreeNode(1)))
  }

  @Test
  fun toArrayCompleteBinaryTree() {
    //   1
    //  / \
    // 2   3
    val root = TreeNode(1).apply {
      left = TreeNode(2)
      right = TreeNode(3)
    }
    assertContentEquals(arrayOf(1, 2, 3), toArray(root))
  }

  @Test
  fun toArrayWithNulls() {
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    val root = TreeNode(3).apply {
      left = TreeNode(9)
      right = TreeNode(20).apply {
        left = TreeNode(15)
        right = TreeNode(7)
      }
    }
    assertContentEquals(arrayOf(3, 9, 20, null, null, 15, 7), toArray(root))
  }

  @Test
  fun toArrayLeafBeforeInternalAtSameLevel() {
    //     1
    //    / \
    //   2   3
    //      / \
    //     4   5
    val root = TreeNode(1).apply {
      left = TreeNode(2)
      right = TreeNode(3).apply {
        left = TreeNode(4)
        right = TreeNode(5)
      }
    }
    assertContentEquals(arrayOf(1, 2, 3, null, null, 4, 5), toArray(root))
  }

  @Test
  fun toArrayLeftSkewed() {
    //   1
    //  /
    // 2
    // /
    // 3
    val root = TreeNode(1).apply {
      left = TreeNode(2).apply {
        left = TreeNode(3)
      }
    }
    assertContentEquals(arrayOf(1, 2, null, 3), toArray(root))
  }

  @Test
  fun toArrayRightSkewed() {
    // 1
    //  \
    //   2
    //    \
    //     3
    val root = TreeNode(1).apply {
      right = TreeNode(2).apply {
        right = TreeNode(3)
      }
    }
    assertContentEquals(arrayOf(1, null, 2, null, 3), toArray(root))
  }

  // ── roundtrip ──────────────────────────────────────────────────────────────

  @Test
  fun roundtripCompleteBinaryTree() {
    val arr = arrayOf<Int?>(1, 2, 3)
    assertContentEquals(arr, toArray(fromArray(arr)))
  }

  @Test
  fun roundtripWithNulls() {
    val arr = arrayOf<Int?>(3, 9, 20, null, null, 15, 7)
    assertContentEquals(arr, toArray(fromArray(arr)))
  }

  @Test
  fun roundtripLeafBeforeInternalAtSameLevel() {
    val arr = arrayOf<Int?>(1, 2, 3, null, null, 4, 5)
    assertContentEquals(arr, toArray(fromArray(arr)))
  }

  @Test
  fun roundtripLeftSkewed() {
    val arr = arrayOf<Int?>(1, 2, null, 3)
    assertContentEquals(arr, toArray(fromArray(arr)))
  }
}
