sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult

final case object Infinite extends DivisionResult

object divide {
  def apply(x: Int, y: Int): DivisionResult =
    if (y == 0) Infinite else Finite(x / y)
}


def sampleFunction(a: Int, b: Int): String = {
  divide(a, b) match {
    case Finite(value) => s"The result is ${value}"
    case Infinite => s"Divison by zero"
  }
}

divide(6, 3)
divide(1, 0)

sampleFunction(6, 3)
sampleFunction(1, 0)






