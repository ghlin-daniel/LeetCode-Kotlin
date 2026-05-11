package p0_p99

import kotlin.test.Test
import kotlin.test.assertSame
import kotlin.test.assertTrue

class P56Test {
  private val p56 = P56()

  private fun assertMerged(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertTrue(expected.contentDeepEquals(actual))
  }

  @Test
  fun example1() {
    assertMerged(
      arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
      p56.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))),
    )
  }

  @Test
  fun adjacentTouchingEndpoints() {
    assertMerged(arrayOf(intArrayOf(1, 5)), p56.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))))
  }

  @Test
  fun unsortedIntervals() {
    assertMerged(
      arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
      p56.merge(arrayOf(intArrayOf(8, 10), intArrayOf(1, 3), intArrayOf(15, 18), intArrayOf(2, 6))),
    )
  }

  @Test
  fun noOverlap() {
    assertMerged(
      arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)),
      p56.merge(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))),
    )
  }

  @Test
  fun containedInterval() {
    assertMerged(arrayOf(intArrayOf(1, 4)), p56.merge(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
  }

  @Test
  fun chainMerge() {
    assertMerged(arrayOf(intArrayOf(1, 5)), p56.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(3, 5))))
  }

  @Test
  fun singleInterval() {
    val input = arrayOf(intArrayOf(4, 7))
    assertSame(input, p56.merge(input))
  }

  @Test
  fun emptyInput() {
    val input = emptyArray<IntArray>()
    assertSame(input, p56.merge(input))
  }
}
