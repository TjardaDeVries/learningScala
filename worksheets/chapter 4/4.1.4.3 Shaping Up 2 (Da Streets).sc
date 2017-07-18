trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides: Int = 4
  val area: Double = height * width
  val perimeter: Double = 2 * height + 2 * width
}

case class Circle(radius: Double) extends Shape {
  val sides: Int = 0
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double = math.Pi * radius * radius
}

case class Rectangle(height: Double, width: Double) extends Rectangular {
}

case class Square(side: Double) extends Rectangular {
  val height: Double = side
  val width: Double = side
}

Circle(2.0).area
Rectangle(2.0, 3.0).area
Square(2.0).area
