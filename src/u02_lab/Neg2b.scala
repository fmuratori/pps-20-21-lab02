package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{Test}


object Neg2b {

  def negMethod(f: String=>Boolean): String=>Boolean = s => !f(s)

  val negLambda: (String=>Boolean) => (String=>Boolean) = f => s => !f(s)

  /////////////////////////////////////////////////////////////////////////////

  val empty: String => Boolean = _==""

  @Test def testNegMethod(){
    notTestAssert(negMethod(empty));
  }

  @Test def testNegLambda() {
    notTestAssert(negLambda(empty));
  }

  def notTestAssert(notEmpty: String=>Boolean): Unit = {
    assertEquals(true, notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))
  }

}
