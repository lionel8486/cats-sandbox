package chapter1

// Type Class Interface Syntax
object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w:JsonWriter[A]): Json =
      w.write(value)
  }
}
