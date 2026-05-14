package p100_p199.p100_p109

import ds.fromArray
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class P101Test {
  private val p101 = P101()

  @Test
  fun nullRoot() {
    assertTrue(p101.isSymmetric(null))
  }

  @Test
  fun singleNode() {
    assertTrue(p101.isSymmetric(fromArray(arrayOf(1))))
  }

  @Test
  fun symmetricTwoLevels() {
    //   1
    //  / \
    // 2   2
    assertTrue(p101.isSymmetric(fromArray(arrayOf(1, 2, 2))))
  }

  @Test
  fun asymmetricValues() {
    //   1
    //  / \
    // 2   3
    assertFalse(p101.isSymmetric(fromArray(arrayOf(1, 2, 3))))
  }

  @Test
  fun leetcodeExample1() {
    //      1
    //    /   \
    //   2     2
    //  / \   / \
    // 3   4 4   3
    assertTrue(p101.isSymmetric(fromArray(arrayOf(1, 2, 2, 3, 4, 4, 3))))
  }

  @Test
  fun leetcodeExample2() {
    //   1
    //  / \
    // 2   2
    //  \   \
    //   3   3
    assertFalse(p101.isSymmetric(fromArray(arrayOf(1, 2, 2, null, 3, null, 3))))
  }

  @Test
  fun missingLeftChild() {
    //   1
    //  / \
    // 2   2
    // /
    // 3
    assertFalse(p101.isSymmetric(fromArray(arrayOf(1, 2, 2, 3, null, null, null))))
  }

  @Test
  fun deepSymmetric() {
    //          1
    //        /   \
    //       2     2
    //      / \   / \
    //     3   4 4   3
    //    / \       / \
    //   5   6     6   5
    assertTrue(
      p101.isSymmetric(fromArray(arrayOf(1, 2, 2, 3, 4, 4, 3, 5, 6, null, null, null, null, 6, 5)))
    )
  }

  @Test
  fun deepAsymmetric() {
    //          1
    //        /   \
    //       2     2
    //      / \   / \
    //     3   4 4   3
    //    /             \
    //   5               9
    assertFalse(
      p101.isSymmetric(fromArray(arrayOf(1, 2, 2, 3, 4, 4, 3, 5, null, null, null, null, null, null, 9)))
    )
  }
}
