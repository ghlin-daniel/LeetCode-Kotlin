package p0_p99

import ds.TreeNode

class P94 {
  /** Time: O(n), Space: O(n) for the result list and O(h) recursion stack (h = height; worst O(n) on a skewed tree). */
  fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return listOf()
    return mutableListOf<Int>().apply {
      addAll(inorderTraversal(root.left))
      add(root.`val`)
      addAll(inorderTraversal(root.right))
    }
  }
}
