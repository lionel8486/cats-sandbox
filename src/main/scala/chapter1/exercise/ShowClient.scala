package chapter1.exercise

object ShowClient extends App {

  import cats.Show
  import cats.instances.int._
  import cats.instances.string._

  val showInt = Show.apply[Int]
  val showString = Show.apply[String]
  println(showInt.show(2))
  println(showString.show("test"))

  import cats.syntax.show._
  println(123.show)
  println("abc".show)


  val cat = Cat("gary", 10, "Yellow")

  implicit val catShow: Show[Cat] = Show.show(catToString)
  private def catToString(cat: Cat): String = {
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
    s"$name is a $age year-old $color cat."
  }

  println(cat.show)
}
