sealed trait Sum[+String, +Double] {

  def map[B](f: Double => B): Sum[String, B] = this match {
    case Success(d) => Success[B](f(d))
    case Failure(s) => Failure(s)
  }

  def flatmap[SS >: String, B](f: Double => Sum[SS, B]): Sum[SS, B] = this match {
    case Success(d) => f(d)
    case Failure(s) => Failure(s)
  }

  def fold[B](succes: Double => B, failure: String => B): B = this match {
    case Success(d) => succes(d)
    case Failure(s) => failure(s)
  }


}
final case class Success[Double](value: Double) extends Sum[Nothing, Double]
final case class Failure[String](message: String) extends Sum[String, Nothing]

val test: Sum[String, Double] = Failure("message")
val test2: Sum[String, Double] = Success(4.0)
val f: Double => String = x => if (x < 5.0) "smaller" else "bigger"

test2.map[Double](_ * 2.0)
test2.map[Boolean](_ < 5.0)
test2.map(f)

test.map[Double](_ * 2.0)
test.map[Boolean](_ < 5.0)
test.map(f)

test2.flatmap[String, Double](x => Success[Double](x * 2.0))
test.flatmap[String, Double](x => Success(x * 2.0))

test2.flatmap(x => Success(x * 2.0))
test.flatmap[String, Double](x => Success(x * 2.0))

//sealed trait Expression {
//
//  def eval: Sum[String, Double] = this match {
//    case Number(v) => Success(v)
//    case Addition(l,r) => (l.eval).map(sum => sum )
//    case Subtraction(l,r) => ???
//  }
//
//}
//final case class Addition(left: Expression, right: Expression) extends Expression
//final case class Subtraction(left: Expression, right: Expression) extends Expression
//final case class Division(left: Expression, right: Expression) extends Expression
//final case class SquareRoot(value: Expression) extends Expression
//final case class Number(value: Double) extends Expression
//
//
//assert(Addition(Number(1), Number(2)).eval == Success(3))
//assert(SquareRoot(Number(-1)).eval == Failure("Square root of negative number"))
//assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
//assert(Division(Addition(Subtraction(Number(8), Number(6)), Number(2)), Number(2)).eval == Success(2.0))











