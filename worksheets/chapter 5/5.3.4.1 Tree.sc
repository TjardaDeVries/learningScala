//A Tree of type A is a Node with a left and right Tree or a Leaf with an element of type A.
sealed trait Tree[A] {

  def fold[B](node: (B, B) => B, leaf: A => B): B =
    this match {
      case Leaf(value) => leaf(value)
      case Node(left, right) => node(left.fold(node, leaf), right.fold(node, leaf))
    }
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

tree.fold[String]((a, b) => a + " " + b, str => str)