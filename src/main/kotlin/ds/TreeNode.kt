package ds

import java.util.*

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun fromArray(intArray: Array<Int?>): TreeNode? {
  if (intArray.isEmpty() || intArray.first() == null) return null

  val queue: Queue<TreeNode> = LinkedList()
  var index = 0
  val head = TreeNode(intArray[index++]!!)
  queue.add(head)
  while (queue.isNotEmpty()) {
    val node = queue.poll()

    if (index >= intArray.size) break
    intArray[index++]?.let {
      node.left = TreeNode(it)
      queue.add(node.left)
    }

    if (index >= intArray.size) break
    intArray[index++]?.let {
      node.right = TreeNode(it)
      queue.add(node.right)
    }
  }

  return head
}

fun toArray(root: TreeNode?): Array<Int?> {
  if (root == null) return arrayOf()

  val list = mutableListOf<Int?>()
  val queue: Queue<TreeNode?> = LinkedList<TreeNode?>().apply { add(root) }
  while (queue.isNotEmpty()) {
    val node = queue.poll()
    list.add(node?.`val`)
    if (node != null) {
      queue.add(node.left)
      queue.add(node.right)
    }
  }
  while (list.isNotEmpty() && list.last() == null) list.removeLast()

  return list.toTypedArray()
}
