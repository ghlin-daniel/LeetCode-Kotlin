package p100_p199.p100_p109

import ds.ListNode
import ds.TreeNode

class P109 {
  /** Time: O(n log n), Space: O(log n) — slow/fast mid-find is O(k) per call; O(log n) levels each scan O(n) total; stack depth O(log n). */
  fun sortedListToBST(head: ListNode?): TreeNode? {
    return bst(head, null)
  }

  private fun bst(head: ListNode?, tail: ListNode?): TreeNode? {
    if (head == tail) return null

    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next?.next != tail && fast?.next != tail) {
      fast = fast?.next?.next
      slow = slow?.next
    }

    return TreeNode(slow!!.`val`).apply {
      left = bst(head, slow)
      right = bst(slow.next, tail)
    }
  }
}
