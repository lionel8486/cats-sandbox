package chapter3

trait Printable[A] {
  def format(value: A): String
  def contramap[B](func: B => A): Printable[B] =
    new Printable[B] {
      def format(value: B): String = Printable.this.format(func(value))
    }
}


object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
}