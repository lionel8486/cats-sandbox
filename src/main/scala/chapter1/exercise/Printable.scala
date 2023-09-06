package chapter1.exercise

trait Printable[A] {
  def format(value: A): String

}

object Printable {
  implicit val stringFormatter: Printable[String] =
    new Printable[String] {
      override def format(value: String): String = value
    }

  implicit val intFormatter: Printable[Int] =
    (value: Int) => value.toString

  implicit val catFormatter: Printable[Cat] =
    (value: Cat) => s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat."
  implicit def format[A](value: A)(implicit printable: Printable[A]): String = {
    printable.format(value)
  }

  implicit def print[A](value: A)(implicit printable: Printable[A]): Unit = {
    println(format(value))
  }

}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = {
      p.format(value)
    }

    def print(implicit p: Printable[A]): Unit = {
      println(value.format)
    }
  }
}