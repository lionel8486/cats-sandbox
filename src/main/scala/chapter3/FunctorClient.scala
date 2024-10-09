package chapter3

import cats.Functor
import cats.syntax.functor._
import chapter1.exercise.PrintableInstances._
import chapter1.exercise.PrintableSyntax.PrintableOps

object FunctorClient extends App {
  val list1 = List(1,2,3)
  val list2 = Functor[List].map(list1)(_ * 2)
  val option1 = Option(123)
  val option2 = Functor[Option].map(option1)(_.toString)

  val func: Int => Int = (x: Int) => x + 1

  val liftedFunc: Option[Int] => Option[Int] = Functor[Option].lift(func)

  println(liftedFunc(Option(1)))


  val func1 = (a: Int) => a + 1
  val func2 = (a: Int) => a * 2
  val func3 = (a: Int) => s"$a!"
  val func4 = func1.map(func2).map(func3)

  println(func4(123))

  doMath(Option(20)).print

  def doMath[F[_]](start: F[Int]) (implicit functor: Functor[F]):F[Int] = start.map(_ + 1 * 2)
}

