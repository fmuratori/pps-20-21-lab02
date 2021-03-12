package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


object Neg2b {

  def neg(f: String=>Boolean): String=>Boolean = s => !f(s)


  @Test def testParityFunction(){
    val empty: String => Boolean = _==""
    val notEmpty = neg(empty)

    assertEquals(true, notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))
  }

}
