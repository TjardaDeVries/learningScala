import animals.Cat
import movies.{Director, Film}

object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, "Chips") => true
      case Cat(_, _) => false
    }
}

ChipShop.willServe(Cat("Brown", "Chips"))


object Dad {
  def rate(film: Film): Double =
    film match {
      case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
      case _ => 3.0
    }
}

Dad.rate(Film("Predator", 1987, 7.9, Director("John", "McTiernan", 1951)))
