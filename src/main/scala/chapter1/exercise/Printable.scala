package chapter1.exercise

import java.util.Date


trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = {
    p.format(value)
  }

  def print[A](value: A)(implicit p: Printable[A]): Unit = {
    println(format(value))
  }
}

object PrintableInstances {
  implicit val formatString: Printable[String] = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val formatInt: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }

  implicit val formatCat: Printable[Cat] = (cat: Cat) => {
    val name = Printable.format(cat.name)
    val age = Printable.format(cat.age)
    val color = Printable.format(cat.color)

    s"$name is a $age year-old $color cat."
  }

  implicit val formatDate: Printable[Date] = (date: Date) => s"${date.toString}"

  implicit def formatOption[A](implicit printable:Printable[A]): Printable[Option[A]] = new Printable[Option[A]] {
    override def format(option: Option[A]): String = option match {
      case Some(value) => s"Some(${printable.format(value)})"
      case None => "None"
    }
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = printable.format(value)

    def print(implicit printable: Printable[A]): Unit = println(format(printable))
  }
}