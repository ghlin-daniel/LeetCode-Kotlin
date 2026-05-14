package p100_p199.p100_p109

import ds.TreeNode
import kotlin.math.max

class P104 {
  /** Time: O(n), Space: O(h) — visits every node once; call stack depth is tree height h, O(n) worst case (skewed). */
  fun maxDepth(root: TreeNode?): Int =
    if (root == null) 0
    else 1 + max(maxDepth(root.left), maxDepth(root.right))
}
