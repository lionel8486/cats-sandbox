package chapter1

object Variance {
  sealed trait Animal
  case class Dog() extends Animal
  case class Cat() extends Animal

  val dogs: List[Dog.type] = List(Dog)
//  val animals: List[Animal] = dogs


}
