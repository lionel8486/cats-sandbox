package chapter3

import chapter3.Printable._
object PrintableClient extends App {
  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }
  implicit val booleanPrintable: Printable[Boolean] =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if (value) "yes" else "no"
    }

  println(format("hello"))
  println(format(true))


  final case class Box[A](value: A)

  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] = p.contramap(_.value)

  println(format(Box("hello world")))
  println(format(Box(true)))
}
