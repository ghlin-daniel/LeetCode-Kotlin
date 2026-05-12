package p500_p599

class Node(var `val`: Int) {
  var children: List<Node?> = listOf()
}

class P589 {
  /** Time: O(n), Space: O(n) — call stack depth equals tree height (O(n) worst case). */
  fun preorder(root: Node?): List<Int> {
    if (root == null) return emptyList()

    return mutableListOf<Int>().apply {
      add(root.`val`)
      root.children.forEach {
        addAll(preorder(it))
      }
    }
  }
}
