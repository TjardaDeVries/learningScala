def divide(numerator: Int, denominator: Int): Option[Int] =
  if (denominator == 0) None else Some(numerator / denominator)

divide(10, 5)
divide(1,2)
divide(2,0)

def divideOptions(numerator: Option[Int], denominator: Option[Int]): Option[Int] = {
  for {
    n <- numerator
    d <- denominator
    r <- divide(n, d)
  } yield r
}

divideOptions(Some(10), Some(5))
divideOptions(Some(1),Some(2))
divideOptions(Some(2),Some(0))


