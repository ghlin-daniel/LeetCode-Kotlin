package p300_p399

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class P359Test {
  @Test
  fun example1() {
    val logger = P359.Logger()
    assertTrue(logger.shouldPrintMessage(1, "foo"))
    assertTrue(logger.shouldPrintMessage(2, "bar"))
    assertFalse(logger.shouldPrintMessage(3, "foo"))
    assertFalse(logger.shouldPrintMessage(8, "bar"))
    assertFalse(logger.shouldPrintMessage(10, "foo"))
    assertTrue(logger.shouldPrintMessage(11, "foo"))
  }

  @Test
  fun allowsImmediatelyAfterWindow() {
    val logger = P359.Logger()
    assertTrue(logger.shouldPrintMessage(0, "a"))
    assertFalse(logger.shouldPrintMessage(9, "a"))
    assertTrue(logger.shouldPrintMessage(10, "a"))
  }

  @Test
  fun distinctMessagesIndependent() {
    val logger = P359.Logger()
    assertTrue(logger.shouldPrintMessage(1, "x"))
    assertTrue(logger.shouldPrintMessage(1, "y"))
    assertFalse(logger.shouldPrintMessage(2, "x"))
    assertFalse(logger.shouldPrintMessage(2, "y"))
  }

  @Test
  fun sameTimestampRepeatedMessageBlocked() {
    val logger = P359.Logger()
    assertTrue(logger.shouldPrintMessage(5, "m"))
    assertFalse(logger.shouldPrintMessage(5, "m"))
  }
}
