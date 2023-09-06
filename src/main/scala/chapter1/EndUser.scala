package chapter1

import JsonSyntax._
object EndUser extends App {
  val dave = Person("Dave", "dave@example.com")

  println(Json.toJson(dave))

  println(dave.toJson)

  val jsonWriterStr = implicitly[JsonWriter[String]]
  println(jsonWriterStr)

  println(Json.toJson(Option("A String")))
  //println(Json.toJson())
}
