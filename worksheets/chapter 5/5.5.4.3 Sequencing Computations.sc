val list = List(1, 2, 3)

list.flatMap((x: Int) => List(x, -x))

sealed trait Maybe[A] {
  def flatmap[B](fn: A => Maybe[B]): Maybe[B] = this match {
    case Full(v) => fn(v)
    case Empty() => Empty[B]()
  }
}

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val list2 = List(Full(3), Full(2), Full(1))

val fn = (x: Int) => (if (x % 2 == 0) Full(x) else Empty()): Maybe[Int]

list2.map(maybe => maybe.flatmap[Int](fn))