package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


object E3cNeg {

  def neg[A](f: A=>Boolean): A=>Boolean = s => !f(s)

  @Test def testIsStringNotEmpty(): Unit = {
    val isEmpty: String => Boolean = _==""
    val notEmpty: String => Boolean = neg(isEmpty)

    assertEquals(true, notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))
  }

  @Test def testIsIntNotEven(): Unit = {
    val isEven: Int => Boolean = _%2==0
    val notEven: Int => Boolean = neg(isEven)

    assertEquals(true, notEven(3))
    assertEquals(false, notEven(2))
    assertEquals(true, notEven(3) && !notEven(10))
  }

}
