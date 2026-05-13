package p100_p199

import ds.TreeNode

class P108 {
  /** Time: O(n), Space: O(log n) — builds every node once; recursion depth is O(log n) since input is sorted (balanced split). */
  fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null

    val mid = nums.size / 2
    return TreeNode(nums[mid]).apply {
      left = bst(nums, 0, mid - 1)
      right = bst(nums, mid + 1, nums.lastIndex)
    }
  }

  fun bst(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (right < left) return null

    val mid = (left + right) / 2
    return TreeNode(nums[mid]).apply {
      this.left = bst(nums, left, mid - 1)
      this.right = bst(nums, mid + 1, right)
    }
  }
}
