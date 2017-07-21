package shapes

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double

  val sides: Int = 4
  val area: Double = height * width
  val perimeter: Double = 2 * height + 2 * width
}

final case class Circle(radius: Double, color: Color) extends Shape {
  val sides: Int = 0
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double = math.Pi * radius * radius
}

final case class Rectangle(height: Double, width: Double, color: Color) extends Rectangular {
}

final case class Square(side: Double, color: Color) extends Rectangular {
  val height: Double = side
  val width: Double = side
}
