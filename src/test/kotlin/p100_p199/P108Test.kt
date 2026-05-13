package p100_p199

import ds.TreeNode
import kotlin.math.abs
import kotlin.math.max
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class P108Test {
  private val p108 = P108()

  private fun inOrder(node: TreeNode?): List<Int> =
    if (node == null) emptyList()
    else inOrder(node.left) + node.`val` + inOrder(node.right)

  private fun height(node: TreeNode?): Int =
    if (node == null) 0 else 1 + max(height(node.left), height(node.right))

  private fun isBalanced(node: TreeNode?): Boolean {
    return node == null || abs(height(node.left) - height(node.right)) <= 1 &&
        isBalanced(node.left) && isBalanced(node.right)
  }

  @Test
  fun emptyArray() {
    assertNull(p108.sortedArrayToBST(intArrayOf()))
  }

  @Test
  fun singleElement() {
    val root = p108.sortedArrayToBST(intArrayOf(0))
    assertEquals(listOf(0), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun twoElements() {
    val root = p108.sortedArrayToBST(intArrayOf(1, 3))
    assertEquals(listOf(1, 3), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun leetcodeExample1() {
    // [-10,-3,0,5,9] → root=0, balanced BST
    val root = p108.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    assertEquals(listOf(-10, -3, 0, 5, 9), inOrder(root))
    assertEquals(0, root!!.`val`)
    assertTrue(isBalanced(root))
  }

  @Test
  fun leetcodeExample2() {
    // [1,3] → root=3, left=1
    val root = p108.sortedArrayToBST(intArrayOf(1, 3))
    assertEquals(listOf(1, 3), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun oddLength() {
    // [1,2,3,4,5] → root=3
    val root = p108.sortedArrayToBST(intArrayOf(1, 2, 3, 4, 5))
    assertEquals(listOf(1, 2, 3, 4, 5), inOrder(root))
    assertEquals(3, root!!.`val`)
    assertTrue(isBalanced(root))
  }

  @Test
  fun evenLength() {
    // [1,2,3,4] → root=nums[2]=3
    val root = p108.sortedArrayToBST(intArrayOf(1, 2, 3, 4))
    assertEquals(listOf(1, 2, 3, 4), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun allNegative() {
    val root = p108.sortedArrayToBST(intArrayOf(-5, -4, -3, -2, -1))
    assertEquals(listOf(-5, -4, -3, -2, -1), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun largerArray() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = p108.sortedArrayToBST(nums)
    assertEquals(nums.toList(), inOrder(root))
    assertTrue(isBalanced(root))
  }
}
