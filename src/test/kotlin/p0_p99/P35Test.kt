package p0_p99

import kotlin.test.Test
import kotlin.test.assertEquals

class P35Test {
  private val p35 = P35()

  @Test
  fun targetFoundAtIndex() {
    assertEquals(2, p35.searchInsert(intArrayOf(1, 3, 5, 6), 5))
  }

  @Test
  fun targetFoundAtIndexOne() {
    assertEquals(1, p35.searchInsert(intArrayOf(1, 3, 5, 6), 3))
  }

  @Test
  fun insertAtEnd() {
    assertEquals(4, p35.searchInsert(intArrayOf(1, 3, 5, 6), 7))
  }

  @Test
  fun insertInMiddle() {
    assertEquals(1, p35.searchInsert(intArrayOf(1, 3, 5, 6), 2))
  }

  @Test
  fun insertAtStart() {
    assertEquals(0, p35.searchInsert(intArrayOf(1, 3, 5, 6), 0))
  }

  @Test
  fun singleElementFound() {
    assertEquals(0, p35.searchInsert(intArrayOf(1), 1))
  }

  @Test
  fun singleElementInsertAfter() {
    assertEquals(1, p35.searchInsert(intArrayOf(1), 2))
  }

  @Test
  fun singleElementInsertBefore() {
    assertEquals(0, p35.searchInsert(intArrayOf(1), 0))
  }

  @Test
  fun twoElementsInsertBetween() {
    assertEquals(1, p35.searchInsert(intArrayOf(1, 3), 2))
  }
}
