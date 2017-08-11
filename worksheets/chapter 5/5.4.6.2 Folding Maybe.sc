sealed trait Maybe[A] {

  fold[B](full: A => B, empty: B): B =
  this match {
    case Full(v) => full(v)
    case Empty() => empty
  }

}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]