trait Feline {
  def colour: String
  def sound: String
  // or:
  // def sound: String =
  //     = this match {
  //      case Cat(_, _) => "meow"
  //      case _ => "roar"
  //    }
}

trait BigCat extends Feline {
  val sound = "roar"
}

case class Cat(colour: String, food: String) extends Feline {
  val sound: String = "meow"
}

case class Lion(colour: String, maneSize: Int) extends BigCat

case class Panther(colour: String) extends BigCat

case class Tiger(colour: String) extends BigCat

Cat("Brown", "Chips").sound

Panther("Yellow").sound
