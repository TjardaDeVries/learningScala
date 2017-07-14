
class Person(first: String, last: String) {
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}

val dave = new Person("Dave", "Gurnell")

// short-hand:
class Person2(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
  def greet(firstName: String = "Some", lastName: String = "Body") =
    "Greetings, " + firstName + " " + lastName + "!"
}

new Person2("Dave", "Gurnell").firstName

new Person2(lastName = "Last", firstName = "First")

new Person2(lastName = "Last", firstName = "First").greet("Awesome")

new Person2(lastName = "Last", firstName = "First").greet(lastName = "Dave")