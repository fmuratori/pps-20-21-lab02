package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object E5Composition {

  def composeInt(f: Int=>Int, g: Int=>Int): Int=>Int = x => f(g(x))

  def compose[A](f: A=>A, g: A=>A): A=>A = x => f(g(x))

  def compose2[A, B, C](f: B=>C, g: A=>B): A=>C = x => f(g(x))

  @Test def testComposition(): Unit = {
    assertEquals(9, composeInt(_-1, _*2)(5))

    assertEquals(9, compose[Int](_-1,_*2)(5))

    assertEquals(9, compose2[Int, Int, Int](_-1,_*2)(5))

    val isEmpty:(String) => Boolean = _==""
    val customMessage:(Boolean) => String = {
      case true => "Empty"
      case false => "Not empty"
    }
    assertEquals("Empty", compose2[String, Boolean, String](customMessage, isEmpty)(""))
    assertEquals("Not empty", compose2[String, Boolean, String](customMessage, isEmpty)("Hello"))
  }

}
