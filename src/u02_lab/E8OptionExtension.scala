package u02_lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object E8OptionExtension {

  sealed trait Option[A] // An Optional data type
  object Option {
    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]

    def isEmpty [A](opt: Option[A]): Boolean = opt match {
      case None() => true
      case _ => false
    }
    def getOrElse [A , B >: A](opt: Option[A], orElse: B ): B = opt match {
      case Some(a) => a
      case _ => orElse
    }

    def flatMap[A, B](opt: Option[A])(f:A => Option[B]): Option[B] = opt match {
      case Some(a) => f(a)
      case _ => None()
    }

    def filter[A](opt: Option[A])(pred:A=>Boolean): Option[A] = opt match {
      case Some(a) => {
        a match {
          case a if pred(a) => Some(a)
          case _ => None()
        }
      }
      case _ => None()
    }

    def map[A, B](opt: Option[A])(map:A=>B): Option[B] = opt match {
      case Some(a) => {
        Some(map(a))
      }
      case _ => None()
    }

    def map2[A, B](opt1: Option[A])(opt2: Option[A])(map:(A, A)=>B): Option[B] = opt1 match {
      case Some(a) => {
        opt2 match {
          case Some(b) => {
            Some(map(a, b))
          }
          case _ => None()
        }
      }
      case _ => None()
    }
  }

  import Option._
  val s1:Option[Int] = Some(1)
  val s2:Option[Int] = Some(2)
  val s3:Option[Int] = None()

  @Test def testOptionBase {
    assertEquals(1, getOrElse(s1, 0))
    assertEquals(0, getOrElse(s3, 0))
    assertEquals(Some(2), flatMap(s1)(i => Some(i+1)))
    assertEquals(Some(3), flatMap(s1)(i => flatMap(s2)(j => Some(i+j))))
    assertEquals(None(), flatMap(s1)(i => flatMap(s3)(j => Some(i+j))))
  }

  @Test def testOptionFilter {
    assertEquals(Some(1), filter(s1)((v: Int) => v==1))
    assertEquals(None(), filter(s1)((v: Int) => v!=1))
    assertEquals(None(), filter(s3)((v: Int) => true))

    assertEquals(Some(5), filter(Some(5))(_>2))
    assertEquals(None(), filter(Some(5))(_>8))
  }

  @Test def testOptionMap {
    assertEquals(Some(true), map(Some(5))(_>2))
    assertEquals(None(), map(None[Int])(_>8))
  }

    @Test def testOptionMap2 {
      assertEquals(Some(3), map2(s1)(s2)((x:Int, y:Int)=> x+y))
      assertEquals(None(), map2(s1)(s3)((x:Int, y:Int)=> x+y))
      assertEquals(None(), map2(s3)(s1)((x:Int, y:Int)=> x+y))

      val str1:Option[String] = Some("A")
      val str2:Option[String] = Some("B")
      val str3:Option[String] = None()
      assertEquals(Some("AB"), map2(str1)(str2)((x:String, y:String)=> x+""+y))
      assertEquals(str3, map2(str1)(str3)((x:String, y:String)=> x+""+y))
      assertEquals(str3, map2(str3)(str2)((x:String, y:String)=> x+""+y))
    }
}
