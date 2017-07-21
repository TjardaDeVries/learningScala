import shapes.{Color, CustomColor, Red, Yellow}

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

object Draw {
  def apply(shape: Shape) =
    shape match {
      //case circle: Circle => s"A circle of radius ${circle.radius}cm"
      case Circle(radius, color) => s"A ${printColor(color)} circle of radius ${radius}cm"
      case Square(side, color) => s"A ${printColor(color)} square with side ${side}cm"
      case Rectangle(width, height, color) => s"A ${printColor(color)} rectangle of width ${width}cm and ${height}cm"
    }

  def printColor(color: Color): String =
    color match {
      case CustomColor(_, _, _, _) => s"${color.lightOrDark}"
      case _ => s"${color.name}"
    }

}

Draw(Circle(10, Yellow))
Draw(Rectangle(3, 4, Red))
Draw(Rectangle(3, 4, CustomColor(255,255,255,"name")))
