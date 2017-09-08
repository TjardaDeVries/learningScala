object Titlecase {
  def unapply(str: String): Option[String] =
    Some(str
      .split(" ")
      .toList
      .map(s => s.substring(0,1).toUpperCase + s.substring(1).toLowerCase )
      .mkString(" ")
    )
}

assert(
  "Sir Lord Doctor David Gurnell" ==
    ("sir lord doctor david gurnell" match {
      case Titlecase(str) => str
    })
)