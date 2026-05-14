package p100_p199.p100_p109

import ds.TreeNode

class P100 {
  /** Time: O(n), Space: O(n) — visits every node once; call stack depth is O(h), O(n) worst case. */
  fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p?.`val` != q?.`val`) return false
    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
  }
}
