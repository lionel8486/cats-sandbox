package chapter4.exercise

import cats.Id
object IdPractice {
  def pure[A](value: A): Id[A] = value
  def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)
  def map[A, B](value: Id[A])(func: A => B): Id[B] = flatMap(value)(func)
}
