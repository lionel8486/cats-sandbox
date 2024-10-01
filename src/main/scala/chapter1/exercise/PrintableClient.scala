package chapter1.exercise

import java.util.Date

object PrintableClient extends App {


  val name = "Gary"
  val age = 8
  val color = "Yellow"
  val cat = Cat(name, age, color)

  println(PrintableInstances.formatString.format(name))
  println(PrintableInstances.formatInt.format(age))
  println(PrintableInstances.formatCat.format(cat))

  import chapter1.exercise.PrintableInstances._
  Printable.print(name)
  Printable.print(age)
  Printable.print(color)
  Printable.print(cat)


  import chapter1.exercise.PrintableSyntax._
  cat.print

  new Date().print
}