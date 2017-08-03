sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait LinkedList[A] {
  def length: Int = this match {
    case End() => 0
    case Pair(h,t) => 1 + t.length
  }
  def contains(item: A):Boolean = this match {
    case End() => false
    case Pair(h,t) =>
      if (h == item)
        true
      else
        t.contains(item)
  }
  def apply(index: Int): Result[A] = this match {
    case Pair(hd, tl) =>
      if (index == 0)
        Success[A](hd)
      else
        tl(index - 1)
    case End() =>
      Failure[A]("Index out of bounds")
  }
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)

val example2 = Pair(1, Pair(2, Pair(3, End())))
assert(example2.contains(3) == true)
assert(example2.contains(4) == false)
assert(End().contains(0) == false)
// This should not compile
//example.contains("not an Int")

val example3 = Pair(1, Pair(2, Pair(3, End())))
//assert(example3(0) == 1)
//assert(example3(1) == 2)
//assert(example3(2) == 3)
//assert(try {
//  example3(3)
//  false
//} catch {
//  case e: Exception => true
//})

assert(example3(0) == Success(1))
assert(example3(1) == Success(2))
assert(example3(2) == Success(3))
assert(example3(3) == Failure("Index out of bounds"))