package u02_lab

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object E3aFunctions {

  val parity: Int => String = (x:Int) => {
    parityFunction(x)
  }

  def parityFunction (x:Int): String = x match {
    case x if (x%2 == 0) => "even"
    case _ => "odd"
  }

  @Test def testParity(){
    assertEquals("even", parity(4))
    assertEquals("odd", parity(5))
  }

  @Test def testParityFunction(){
    assertEquals("even", parityFunction(4))
    assertEquals("odd", parityFunction(5))
  }
}
