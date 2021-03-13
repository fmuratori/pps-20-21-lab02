package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object E6Fibonacci {

//  @annotation . tailrec
  def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fib(n-2) + fib(n-1)
  }


  @Test def testFibonacci(): Unit = {
    assertEquals(0, fib(0))
    assertEquals(1, fib(1))
    assertEquals(1, fib(2))
    assertEquals(2, fib(3))
    assertEquals(3, fib(4))

  }
}
