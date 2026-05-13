package p100_p199

import ds.TreeNode
import kotlin.math.abs
import kotlin.math.max

class P110 {
  /** Time: O(n), Space: O(h) — each node visited once via post-order; stack depth is h, O(n) worst case (skewed). */
  fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true

    fun height(root: TreeNode?): Int {
      if (root == null) return 0

      val left = height(root.left)
      val right = height(root.right)
      if (left == -1 || right == -1) return -1
      if (abs(left - right) > 1) return -1

      return 1 + max(left, right)
    }

    return height(root) != -1
  }
}
