package p100_p199

import ds.TreeNode
import java.util.*

class P102 {
  /** Time: O(n), Space: O(n) — each node is enqueued/dequeued once; queue holds at most the widest level (O(n) leaves). */
  fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result = mutableListOf<List<Int>>()
    val queue = LinkedList<TreeNode>().apply { add(root) }

    while (queue.isNotEmpty()) {
      val list = mutableListOf<Int>()
      var size = queue.size
      while (size-- > 0) {
        val node = queue.poll()
        list.add(node.`val`)
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
      }
      result.add(list)
    }

    return result
  }
}
