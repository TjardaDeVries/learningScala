trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

case class Person(name: String, email: String)

object EmailOnlyPersonEqual extends Equal[Person] {
  def equal(v1: A, v2: A): Boolean =
    v1. email == v2.email
}

object PersonEqual extends Equal[Person] {
  def equal(v1: A, v2: A): Boolean =
    v1.email == v2.email &&
      v1.name == v2.name
}