object Positive {
  def unapply(int: Int): Option[Int] =
    if (int > 0) Some(int) else None
}

assert(
  "No" ==
    (0 match {
      case Positive(_) => "Yes"
      case _ => "No"
    })
)

assert(
  "Yes" ==
    (42 match {
      case Positive(_) => "Yes"
      case _ => "No"
    })
)