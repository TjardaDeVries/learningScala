class Cat(val colour: String, val food: String) {}

val oswald = new Cat(colour = "Black", food = "Milk")
val henderson = new Cat("Ginger", "Chips")
val quentin = new Cat("Tabby and white", "Curry")


object ChipShop {

  def willServe(cat: Cat): Boolean =
    if (cat.food == "Chips")
      true
    else
      false

  assert(willServe(oswald) == false)
  assert(willServe(henderson) == true)
  assert(willServe(oswald) == false)

}

ChipShop


object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a
