package chapter4.exercise

import chapter1.exercise.PrintableSyntax.PrintableOps
import chapter1.exercise.PrintableInstances._
object MonadClient extends App {

  import cats.instances.option._ // for Monad
  import cats.instances.list._ // for Monad
  import cats.syntax.applicative._ // for pure
  1.pure[Option].print
  // res4: Option[Int] = Some(1)
  1.pure[List].print
  // res5: List[Int] = List(1)

}
