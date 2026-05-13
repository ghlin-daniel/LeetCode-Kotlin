package p100_p199

import ds.TreeNode

class P101 {
  /** Time: O(n), Space: O(n) — visits every node once; call stack depth is O(h), O(n) worst case. */
  fun isSymmetric(root: TreeNode?): Boolean {
    return root == null || check(root.left, root.right)
  }

  private fun check(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p?.`val` != q?.`val`) return false
    return check(p?.left, q?.right) && check(p?.right, q?.left)
  }
}
