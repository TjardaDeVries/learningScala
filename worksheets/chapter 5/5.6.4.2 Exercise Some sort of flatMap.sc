sealed trait Sum[+A, +B] {
  def flatMap[C](f: B => Sum[A, C]): Sum[A, C] =
    this match {
      case Left(a) => Left(a)
      case Right(b) => f(b)
    }
}
final case class Left[A](value: A) extends Sum[A, Nothing]
final case class Right[B](value: B) extends Sum[Nothing, B]