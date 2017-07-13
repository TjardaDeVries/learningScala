

object calc {

  def square(x: Double): Double = x * x

  def cube(x: Double): Double = x * square(x)

  assert(square(2.0) == 4.0)
  assert(square(3.0) == 9.0)
  assert(square(-2.0) == 4.0)

  assert(cube(2.0) == 8.0)
  assert(cube(3.0) == 27.0)
  assert(cube(-2.0) == -8.0)

}


object calc2 {

  def square(x: Double): Double = x * x
  def cube(x: Double): Double = x * square(x)
  def square(x: Int): Int = x * x
  def cube(x: Int): Int = x * square(x)

}

val x: Int = calc square 2 toInt