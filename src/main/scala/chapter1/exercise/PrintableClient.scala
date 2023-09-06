package chapter1.exercise

import PrintableSyntax._
object PrintableClient extends App {
  val s = "This is a String."

  Printable.print(s)

  val i = 35

  Printable.print(i)


  val cat = Cat("Tom", 3, "blue")
  Printable.print(cat)

  s.print
  i.print
  cat.print
}
