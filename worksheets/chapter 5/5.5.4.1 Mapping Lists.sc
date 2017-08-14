

//val list = List(1, 2, 3)
//
//list.map(_ * 2)
//list.map(x => x * 2)
//list.map(_ + 1)
//list.map(_ / 3)

sealed trait LinkedList[A] {
  def map[B](fn: A => B): LinkedList[B] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      case End() => End[B]()
    }
  def flatMap[B](fn: A => LinkedList[B]):LinkedList[B] =
    this match {
      case Pair(hd,tl) => concat(fn(hd), tl.flatMap(fn))
      case End() => End[B]()
    }
  def concat(list1: LinkedList[A], list2: LinkedList[A]): LinkedList[A] = ???
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

list.map(_ * 2)
list.map(x => x * 2)
list.map(_ + 1)
list.map(_ / 3)