sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double

  val sides: Int = 4
  val area: Double = height * width
  val perimeter: Double = 2 * height + 2 * width
}

final case class Circle(radius: Double) extends Shape {
  val sides: Int = 0
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double = math.Pi * radius * radius
}

final case class Rectangle(height: Double, width: Double) extends Rectangular {
}

final case class Square(side: Double) extends Rectangular {
  val height: Double = side
  val width: Double = side
}

object Draw {
  def apply(shape: Shape) =
    shape match {
      case temp: Circle => s"A circle of radius ${radius}cm"
      case Square(side) => s"A square with side ${side}cm"
      case Rectangle(width,height) => s"A rectangle of width ${width}cm and ${height}cm"
    }
}

Draw(Circle(10))
Draw(Rectangle(3, 4))
