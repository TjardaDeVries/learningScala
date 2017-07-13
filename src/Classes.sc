
class Person {
  val firstName = "Noel"
  val lastName = "Welsh"
  def name = firstName + " " + lastName
}

val noel = new Person

noel.firstName

object alien {
  def greet(p: Person) =
    "Greetings, " + p.firstName + " " + p.lastName
}

alien.greet(noel)



