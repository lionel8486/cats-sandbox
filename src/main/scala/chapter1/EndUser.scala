package chapter1

import JsonWriterInstances._

object EndUser extends App {
  println(Json.toJson(Person("Dave", "dave@example.com")))
}
