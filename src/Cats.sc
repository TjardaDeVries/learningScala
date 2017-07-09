
object Oswald {

  val colour: String = "Black"
  val food: String = "Milk"

}

object calc {

  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)

}


object calc2 {

  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)
  def square(x: Int) = x * x
  def cube(x: Int) = x * square(x)

}

val x: Int = calc square 2 toInt

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
