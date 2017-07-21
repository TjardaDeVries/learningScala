sealed trait Color {
  def red: Int
  def green: Int
  def blue: Int
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
}

final case object Yellow extends Color {
  val red = 255
  val green = 255
  val blue = 0
}

final case object Pink extends Color {
  val red = 255
  val green = 0
  val blue = 255
}

final case class CustomColor(red: Int, green: Int, blue: Int) extends Color

CustomColor(127, 127, 127).lightOrDark
CustomColor(0,0,0).lightOrDark
CustomColor(255,255,255).lightOrDark

