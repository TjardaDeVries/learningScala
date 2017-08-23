def addOptions(optionA: Option[Int], optionB: Option[Int]) = {
  for {
    a <- optionA
    b <- optionB
  } yield a + b
}

addOptions(Some(3), Some(5))
addOptions(None, Some(3))
addOptions(Some(9), None)

def addOptions2(optionA: Option[Int], optionB: Option[Int]) =
  optionA.flatMap(a => optionB.map(b => a + b))

addOptions2(Some(3), Some(5))
addOptions2(None, Some(3))
addOptions2(Some(9), None)

def addOptions(optionA: Option[Int], optionB: Option[Int], optionC: Option[Int]) = {
  for {
    a <- optionA
    b <- optionB
    c <- optionC
  } yield a + b + c
}

addOptions(Some(3), Some(5), Some(6))
addOptions(None, Some(3), None)
addOptions(Some(9), None, None)

def addOptions2(optionA: Option[Int], optionB: Option[Int], optionC: Option[Int]) =
  optionA.flatMap(a => optionB.flatMap(b => optionC.map(c => a + b + c)))

addOptions2(Some(3), Some(5), Some(6))
addOptions2(None, Some(3), None)
addOptions2(Some(9), None, None)