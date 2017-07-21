sealed trait Calculation
final case class Succes(result: Int) extends Calculation
final case class Failure(message: String) extends Calculation
