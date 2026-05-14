package p200_p299

import ds.TreeNode

class P226 {
  /** Time: O(n), Space: O(n) — visits every node once; call stack depth equals tree height (O(n) worst case). */
  fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val l = invertTree(root.right)
    val r = invertTree(root.left)
    return root.apply {
      left = l
      right = r
    }
  }
}
