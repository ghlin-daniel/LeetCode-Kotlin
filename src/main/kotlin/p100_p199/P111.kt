package p100_p199

import ds.TreeNode

class P111 {
  /** Time: O(n), Space: O(h) — visits every node once; call stack depth is tree height h, O(n) worst case (skewed). */
  fun minDepth(root: TreeNode?): Int {
    return if (root == null) 0
    else {
      val left = minDepth(root.left)
      val right = minDepth(root.right)
      if (left == 0 || right == 0) {
        left + right + 1
      } else {
        minOf(left, right) + 1
      }
    }
  }
}
