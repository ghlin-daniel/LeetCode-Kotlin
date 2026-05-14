package p100_p199

import ds.TreeNode

class P129 {
  /** Time: O(n), Space: O(n) — visits every node once; call stack depth equals tree height (O(n) worst case). */
  fun sumNumbers(root: TreeNode?): Int {
    if (root == null) return 0

    var result = 0
    fun sumNumbers(node: TreeNode, num: Int) {
      val newNum = num * 10 + node.`val`
      if (node.left == null && node.right == null) {
        result += newNum
      } else {
        node.left?.let { sumNumbers(it, newNum) }
        node.right?.let { sumNumbers(it, newNum) }
      }
    }
    sumNumbers(root, 0)

    return result
  }
}
