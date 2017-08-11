
sealed trait Maybe[A] {

//  def map[B](fn: A => B): Maybe[B] =
//    this match {
//      case Full(v) => Full(fn(v))
//      case Empty() => Empty[B]()
//    }

  def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => fn(A)
      case Empty() => Empty[B]()
    }

  def map[B](fn: A => B): Maybe[B] =
    flatMap[B](v => Full(fn(v)))

}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]