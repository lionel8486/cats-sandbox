package chapter3

import chapter3.CodecInstances.{stringCodec, _}
import chapter3.Codec._
case class Box[A](value: A)
object CodecClient extends App {

  println(Codec.encode(1))

  println(Codec.decode("1")(stringCodec))

  println(Codec.encode(1.2))

  println(encode(Box(123.4)))

  println(decode[Double]("123.5"))
  println(decode[Box[Double]]("123.6"))
}

