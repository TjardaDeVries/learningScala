val subjects = List("Noel", "The cat", "The dog")
val verbs = List("wrote", "chased", "slept on")
val objects = List("the book", "the ball", "the bed")

for {
  s <- subjects
  v <- verbs
  o <- objects
} println(s"$s $v $o")

subjects.flatMap(
  s => selectVerbs((s)).flatMap(
    v => objects.map(
      o => (s, v, o))))


def selectVerbs(subject: String): List[String] =
subject match {
  case "Noel" => List("wrote", "chased", "slept on")
  case "The cat" => List("meowed at", "chased", "slept on")
  case "The dog" => List("barked at", "chased", "slept on")
}