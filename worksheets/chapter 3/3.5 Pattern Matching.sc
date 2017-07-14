
case class Person(firstName: String, lastName: String)

object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person("Han", _) => "Stop, rebel scum!"
      case Person(first, last) => s"Move along, $first"
    }
}

Stormtrooper.inspect(Person("Noel", "Welsh"))

Stormtrooper.inspect(Person("Han", "Solo"))