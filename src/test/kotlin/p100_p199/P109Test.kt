package p100_p199

import ds.ListNode
import ds.TreeNode
import kotlin.math.abs
import kotlin.math.max
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class P109Test {
  private val p109 = P109()

  private fun linkedList(vararg vals: Int): ListNode? {
    val dummy = ListNode(0)
    var cur = dummy
    for (v in vals) {
      cur.next = ListNode(v); cur = cur.next!!
    }
    return dummy.next
  }

  private fun inOrder(node: TreeNode?): List<Int> =
    if (node == null) emptyList<Int>()
    else inOrder(node.left) + node.`val` + inOrder(node.right)

  private fun height(node: TreeNode?): Int =
    if (node == null) 0 else 1 + max(height(node.left), height(node.right))

  private fun isBalanced(node: TreeNode?): Boolean =
    node == null || abs(height(node.left) - height(node.right)) <= 1 &&
        isBalanced(node.left) && isBalanced(node.right)

  @Test
  fun emptyList() {
    assertNull(p109.sortedListToBST(null))
  }

  @Test
  fun singleElement() {
    val root = p109.sortedListToBST(linkedList(0))
    assertEquals(listOf(0), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun twoElements() {
    val root = p109.sortedListToBST(linkedList(1, 3))
    assertEquals(listOf(1, 3), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun leetcodeExample1() {
    // [-10,-3,0,5,9] → root=0
    val root = p109.sortedListToBST(linkedList(-10, -3, 0, 5, 9))
    assertEquals(listOf(-10, -3, 0, 5, 9), inOrder(root))
    assertEquals(0, root!!.`val`)
    assertTrue(isBalanced(root))
  }

  @Test
  fun leetcodeExample2() {
    // [0,1,2,3]
    val root = p109.sortedListToBST(linkedList(0, 1, 2, 3))
    assertEquals(listOf(0, 1, 2, 3), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun oddLength() {
    // [1,2,3,4,5] → root=3
    val root = p109.sortedListToBST(linkedList(1, 2, 3, 4, 5))
    assertEquals(listOf(1, 2, 3, 4, 5), inOrder(root))
    assertEquals(3, root!!.`val`)
    assertTrue(isBalanced(root))
  }

  @Test
  fun allNegative() {
    val root = p109.sortedListToBST(linkedList(-5, -4, -3, -2, -1))
    assertEquals(listOf(-5, -4, -3, -2, -1), inOrder(root))
    assertTrue(isBalanced(root))
  }

  @Test
  fun largerList() {
    val vals = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = p109.sortedListToBST(linkedList(*vals))
    assertEquals(vals.toList(), inOrder(root))
    assertTrue(isBalanced(root))
  }
}
