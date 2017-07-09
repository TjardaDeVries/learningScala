object person {

  val firstName = "Tjarda"
  val lastName = "de Vries"

}

object alien {

  def greet(p: person.type): String =
    "greetings, " + p.firstName

}

println(alien.greet(person))


