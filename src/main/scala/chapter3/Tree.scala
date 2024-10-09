package chapter3
sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  implicit class treeFunctorOps[A](tree: Tree[A]) {
    def map[B](f: A => B): Tree[B] = {
      tree match {
        case Branch(left, right) => Branch(left.map(f), right.map(f))
        case Leaf(value) => Leaf(f(value))
      }
    }
  }
}