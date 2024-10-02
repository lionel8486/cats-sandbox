package chapter1.exercise
import cats.implicits._
import cats._
import java.util.Date
object EqClient extends App {
  println(123 === 123)
  println(123 =!= 234)

  println((Some(1): Option[Int]) === None)
  println(Option(1) === Option.empty[Int])

  println(1.some === none[Int])
  println(1.some =!= none[Int])

  implicit val dateEq: Eq[Date] = {(d1, d2) => d1.getTime === d2.getTime}

  val x = new Date()
  val y = new Date()
  println( x === x)
  println( x === y)


  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  val optionCat1 = Option(cat1)
  val optionCat2 = Option(cat2)

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (c1, c2) => {
      c1.name === c2.name && c1.age === c2.age && c1.color === c2.color
    }
    }

  println(cat1 === cat2)
  println(cat1 =!= cat2)
  println(optionCat1 === optionCat2)
  println(optionCat1 =!= optionCat2)

}
