trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

implicit object CaseInsensitiveEqual extends Equal[String] {
  def equal(s1: String, s2: String) = s1.toUpperCase == s2.toUpperCase
}

implicit class EqualOps[A](v1: A) {
  def ===(v2: A)(implicit e: Equal[A]) =
    e.equal(v1, v2)
}

"abcd".===("ABCD")