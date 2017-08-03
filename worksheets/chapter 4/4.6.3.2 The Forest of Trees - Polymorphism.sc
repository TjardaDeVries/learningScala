sealed trait Tree {
  def sum: Int
  def double: Tree
}
final case class Leaf(int: Int) extends Tree {
  def sum: Int = int
  def double: Tree = Leaf(2*int)
}
final case class Node(left: Tree, right: Tree) extends Tree {
  def sum: Int = left.sum + right.sum
  def double: Tree = Node(left.double, right.double)
}