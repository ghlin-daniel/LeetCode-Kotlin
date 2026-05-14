package p100_p199

import ds.TreeNode

class P145 {
  /** Time: O(n), Space: O(n) — call stack depth equals tree height (O(n) worst case). */
  fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    return mutableListOf<Int>().apply {
      addAll(postorderTraversal(root.left) + postorderTraversal(root.right))
      add(root.`val`)
    }
  }
}
