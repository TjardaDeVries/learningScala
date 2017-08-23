
def calculator(operand1: String, operator: String, operand2: String): Unit = {
  val result: Option[Int] =
    operator match {
      case "+" => sumOptions(readInt(operand1), readInt(operand2))
      case "/" => divideOptions(readInt(operand1), readInt(operand2))
    }

  result match {
    case Some(number) => println("The result is " + number)
    case None => println("Something went wrong!")
  }

}

def readInt(str: String): Option[Int] =
  if(str matches "\\d+") Some(str.toInt) else None

def sum(a: Int, b: Int): Option[Int] =
  Some(a + b)

def sumOptions(optionA: Option[Int], optionB: Option[Int]): Option[Int] = {
  for {
    a <- optionA
    b <- optionB
    r <- sum(a, b)
  } yield r
}

def divide(numerator: Int, denominator: Int): Option[Int] =
  if (denominator == 0) None else Some(numerator / denominator)

def divideOptions(numerator: Option[Int], denominator: Option[Int]): Option[Int] = {
  for {
    n <- numerator
    d <- denominator
    r <- divide(n, d)
  } yield r
}

// We can think of each clause in the for comprehension as an expression that says:
// if this clause results in a Some, extract the value and continue…
// if it results in a None, exit the for comprehension and return None.

calculator("1", "+", "2")
calculator("1", "+", "a")
calculator("6", "/", "2")
calculator("6", "/", "0")