sealed trait Expression {
  def eval: Calculation =
    this match {

      case Addition(left, right) =>
        left.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result_1) =>
            right.eval match {
              case Failure(msg) => Failure(msg)
              case Success(result_2) => Success(result_1 + result_2)
            }
        }

      case Substraction(left, right) =>
        left.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result_1) =>
            right.eval match {
              case Failure(msg) => Failure(msg)
              case Success(result_2) => Success(result_1 - result_2)
            }
        }

      case Division(left, right) =>
        left.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result_1) =>
            right.eval match {
              case Failure(msg) => Failure(msg)
              case Success(0) => Failure("Division by zero")
              case Success(result_2) => Success(result_1 / result_2)
            }
        }


      case SquareRoot(expr) =>
        expr.eval match {
          case Failure(msg) => Failure(msg)
          case Success(result) =>
            if (result < 0)
              Failure("Square root of negative number")
            else
              Success(Math.sqrt(result))
        }

      case Number(value) => Success(value)

    }
}

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Substraction(left: Expression, right: Expression) extends Expression

final case class Division(left: Expression, right: Expression) extends Expression

final case class SquareRoot(exp: Expression) extends Expression

final case class Number(value: Double) extends Expression

sealed trait Calculation

final case class Success(result: Double) extends Calculation

final case class Failure(message: String) extends Calculation

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval ==
  Failure("Square root of negative number"))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
