package p0_p99

import kotlin.test.Test
import kotlin.test.assertEquals

class P70Test {
  private val p70 = P70()

  @Test
  fun oneStep() {
    assertEquals(1, p70.climbStairs(1))
  }

  @Test
  fun twoSteps() {
    assertEquals(2, p70.climbStairs(2))
  }

  @Test
  fun threeSteps() {
    assertEquals(3, p70.climbStairs(3))
  }

  @Test
  fun fourSteps() {
    assertEquals(5, p70.climbStairs(4))
  }

  @Test
  fun fiveSteps() {
    assertEquals(8, p70.climbStairs(5))
  }

  @Test
  fun largerInputNearConstraintUpperBound() {
    assertEquals(1836311903, p70.climbStairs(45))
  }
}
