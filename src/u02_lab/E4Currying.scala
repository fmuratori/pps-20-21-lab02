package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object E4Currying {

  val testAscendingOrder: (Int, Int, Int) => Boolean = (x, y, z) => x < y && y < z

  val p1: Int => Int => Int => Boolean = x => y => z => testAscendingOrder(x, y, z)
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => testAscendingOrder(x, y, z)
  def p3(x: Int)(y: Int)(z:Int): Boolean = testAscendingOrder(x, y, z)
  def p4(x:Int, y:Int, z:Int): Boolean = testAscendingOrder(x, y, z)

  @Test def testCurrying(): Unit = {
    assertEquals(true, p1(1)(2)(3))
    assertEquals(true, p2(1, 2, 3))
    assertEquals(true, p3(1)(2)(3))
    assertEquals(true, p4(1, 2, 3))

    assertEquals(false, p1(4)(1)(2))
    assertEquals(false, p2(4, 1, 2))
    assertEquals(false, p3(4)(1)(2))
    assertEquals(false, p4(4, 1, 2))
  }

}
