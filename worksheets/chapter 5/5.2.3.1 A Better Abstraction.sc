
sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
  def sum: Int = fold[Int](0, (hd, tl) => hd + tl: Int)
  def lenght: Int = fold[Int](0, (_, tl) => 1 + tl)
  def product: Int = fold[Int](1, (hd, tl) => hd * tl)
  def double: IntList = fold[IntList](End, (hd, tl) => Pair(2*hd, tl))


}
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

val sum = (x: Int, y: Int) => x + y

val example = Pair(1, Pair(2, Pair(3, End)))

example.sum
example.lenght
example.product

example.double






