package p300_p399

import ds.TreeNode
import java.util.*

class P314 {
  /** Time: O(n log k), Space: O(n) — n = node count, k = distinct columns (k ≤ n). */
  fun verticalOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    data class TagNode(
      val tag: Int,
      val node: TreeNode,
    )

    val result = mutableMapOf<Int, MutableList<Int>>()
    val queue = LinkedList<TagNode>().apply { add(TagNode(0, root)) }

    while (queue.isNotEmpty()) {
      val node = queue.poll()
      result.computeIfAbsent(node.tag) {
        mutableListOf()
      }.add(node.node.`val`)
      node.node.left?.let { queue.add(TagNode(node.tag - 1, it)) }
      node.node.right?.let { queue.add(TagNode(node.tag + 1, it)) }
    }

    return result.keys.sorted().map { result[it]!! }
  }
}
