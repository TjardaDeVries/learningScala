import scala.annotation.tailrec

sealed trait IntList

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

Pair(1, Pair(2, Pair(3, End)))


val example = Pair(1, Pair(2, Pair(3, End)))
assert(sum(example) == 6)
assert(sum(example.tail) == 5)
assert(sum(End) == 0)

//@tailrec
def sum(list: IntList): Int =
  list match {
    case End => 0
    case Pair(head, tail) => head + sum(tail)
  }

@tailrec
def sum2(list: IntList, total: Int = 0): Int =
  list match {
    case End => total
    case Pair(hd, tl) => sum2(tl, total + hd)
  }