package chapter3

import chapter3.Tree._
object TreeClient extends App {

  val branch = Branch(Leaf(10), Leaf(20))

  println(branch.map(_ * 2))

}
