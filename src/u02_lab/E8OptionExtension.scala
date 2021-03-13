package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object E8OptionExtension {

  val PI = 3.14

  sealed trait Shape
  object Shape {
    def area(shape: Shape): Double = shape match {
      case Rectangle(l1, l2) => l1*l2
      case Circle(r) => 2*r*PI
      case Square(l) => l*l
    }

    def perimeter(shape: Shape) = shape match {
      case Rectangle(l1, l2) => l1*2 + l2*2
      case Circle(r) => r*r*PI
      case Square(l) => l*4
    }

    case class Rectangle(l1: Double, l2:Double) extends Shape
    case class Circle(r: Double) extends Shape
    case class Square(i: Int) extends Shape

  }
  
  val rectangle:Shape.Rectangle = Shape.Rectangle(2, 3)
  val circle: Shape = Shape.Circle(10)
  val square: Shape = Shape.Square(1)

  @Test def testPerimeter(): Unit = {
    assertEquals(10, Shape.perimeter(rectangle))
    assertEquals(314, Shape.perimeter(circle))
    assertEquals(4, Shape.perimeter(square))
  }

  @Test def testArea(): Unit = {
    assertEquals(6, Shape.area(rectangle))
//    assertEquals(62.8, Shape.area(circle))
      assertEquals(1, Shape.area(square))
  }
}
