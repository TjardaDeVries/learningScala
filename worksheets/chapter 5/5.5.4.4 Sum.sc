sealed trait Sum[A, B] {
  def fold[C](error: A => C, success: B => C): C =
    this match {
      case Failure(v) => error(v)
      case Success(v) => success(v)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(a) =>
      case Success(b) =>
    }

}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]