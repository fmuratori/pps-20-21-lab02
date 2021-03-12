package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


object Neg2c {

  def neg[A](f: A=>Boolean): A=>Boolean = s => !f(s)

  /////////////////////////////////////////////////////////////////////////////

  val isEmpty: String => Boolean = _==""
  val isEven: Int => Boolean = _%2==0

  @Test def testIsIntEven(): Unit ={
    assertEquals(false, isEven(3))
    assertEquals(true, isEven(2))
    assertEquals(false, isEven(3) && !isEven(10))

  }
  @Test def testIsStringEmpty(): Unit ={
    assertEquals(false, isEmpty("foo"))
    assertEquals(true, isEmpty(""))
    assertEquals(false, isEmpty("foo") && !isEmpty(""))

  }

  @Test def testIsStringNotEmpty(): Unit = {
    val notEmpty: String => Boolean = neg(isEmpty)

    assertEquals(true, notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))
  }

  @Test def testIsIntNotEven(): Unit = {
    val notEven: Int => Boolean = neg(isEven)

    assertEquals(true, notEven(3))
    assertEquals(false, notEven(2))
    assertEquals(true, notEven(3) && !notEven(10))
  }

}
