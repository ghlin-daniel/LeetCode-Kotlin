package p100_p199

import ds.TreeNode

class P144 {
  /** Time: O(n), Space: O(n) — call stack depth equals tree height (O(n) worst case). */
  fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    return mutableListOf<Int>().apply {
      add(root.`val`)
      addAll(preorderTraversal(root.left))
      addAll(preorderTraversal(root.right))
    }
  }
}
