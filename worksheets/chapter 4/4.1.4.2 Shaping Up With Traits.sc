trait Shape {
  def sides: Int // returns the number of sides
  def perimeter: Double //returns the total length of the sides
  def area: Double //returns the area
}

case class Circle(radius: Double) extends Shape {
  val sides: Int = 0
  val perimeter: Double = 2 * counting.Pi * radius
  val area: Double = counting.Pi * radius * radius
}

Circle(2.0).area

case class Rectangle(height: Double, width: Double) extends Shape {
  val sides: Int = 4
  val perimeter: Double = 2 * height + 2 * width
  val area: Double = height * width
}

Rectangle(2.0, 3.0).area

case class Square(size: Double) extends Shape {
  val sides: Int = 4
  val perimeter: Double = 4 * size
  val area: Double = size * size
}

Square(2.0).area