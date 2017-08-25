trait HtmlWriter[A] {
  def write(in: A): String
}

object HtmlUtil {
  def htmlify[A](data: A)(implicit writer: HtmlWriter[A]): String = {
    writer.write(data)
  }
}

// Here we define an implicit value
implicit object ApproximationWriter extends HtmlWriter[Int] {
  def write(in: Int): String =
    s"It's definitely less than ${((in / 10) + 1) * 10}"
}

// Implicit value is found and used here
HtmlUtil.htmlify(2)