package p500_p599

class P590 {
  /** Time: O(n), Space: O(n) — call stack depth equals tree height (O(n) worst case). */
  fun postorder(root: Node?): List<Int> {
    if (root == null) return emptyList()

    return mutableListOf<Int>().apply {
      root.children.forEach {
        addAll(postorder(it))
      }
      add(root.`val`)
    }
  }
}
