
case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

val dave = new Person("Dave", "Gurnell")

Person

dave.toString

new Person("Noel", "Welsh").equals(new Person("Noel", "Welsh"))

new Person("Noel", "Welsh") == new Person("Noel", "Welsh")

dave.copy()
dave.copy(firstName = "Dave2")
dave.copy(lastName = "Gurnell2")

new Person("Noel", "Welsh") eq (new Person("Noel", "Welsh"))

dave eq dave
