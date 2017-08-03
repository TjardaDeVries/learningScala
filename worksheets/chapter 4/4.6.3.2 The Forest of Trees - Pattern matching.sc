sealed trait Tree {
  def sum: Int =
    this match {
      case Leaf(int) => int
      case Node(left, right) => left.sum + right.sum
    }
  def double: Tree =
    this match {
      case Leaf(int) => Leaf(2*int)
      case Node(left, right) => Node(left.double, right.double)
    }

}
final case class Leaf(int: Int) extends Tree
final case class Node(left: Tree, right: Tree) extends Tree