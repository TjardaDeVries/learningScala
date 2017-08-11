// A Tree of type A is a Node with a left and right Tree or a Leaf with an element of type A.

sealed trait Tree[A] {

  def fold[B](leaf: A => B, node: (B, B) => B): B =
    this match {
      case Leaf(e) => leaf(e)
      case Node(l, r) => node(l.fold(leaf, node), r.fold(leaf, node))
    }

}

case class Leaf[A](e: A) extends Tree[A]

case class Node[A](l: Tree[A], r: Tree[A]) extends Tree[A]

val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

tree.fold[String](string => string, (a,b) => a + " " + b)