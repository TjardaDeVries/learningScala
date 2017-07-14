package persons

case class Person(firstName: String,
                  lastName: String) {
  def name = firstName + " " + lastName
}

object Person {
  // apply method is overloaded!
  def apply(name: String): Person = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}
