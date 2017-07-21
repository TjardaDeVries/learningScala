package shapes

sealed trait Color {
  def red: Int
  def green: Int
  def blue: Int
  def name: String
  val brightness: Double = math.sqrt(
    red * red * .241 +
      green * green * .691 +
      blue * blue * .068);
  def lightOrDark: String = if (brightness < 130) "dark" else "light"
}

final case object Red extends Color {
  val red = 255
  val green = 0
  val blue = 0
  val name = "red"
}

final case object Yellow extends Color {
  val red = 255
  val green = 255
  val blue = 0
  val name = "yellow"
}

final case object Pink extends Color {
  val red = 255
  val green = 0
  val blue = 255
  val name = "pink"
}

final case class CustomColor(red: Int, green: Int, blue: Int, name: String) extends Color