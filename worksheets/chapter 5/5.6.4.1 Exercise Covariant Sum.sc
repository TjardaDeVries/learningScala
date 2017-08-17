sealed trait Sum[+A, +B] {
  def flatmap[C, D](fn: (A, B) => Sum[C, D]): Sum[C, D] =
    this match {
      case Left(a) => fn(a, _)
      case Right(b) => fn(_, b)
    }
}


final case class Left[A](value: A) extends Sum[A, Nothing]
final case class Right[B](value: B) extends Sum[Nothing, B]

