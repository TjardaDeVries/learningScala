final case class Rational(numerator: Int, denominator: Int)

implicit val absOrdering = Ordering.fromLessThan[Rational]{
  (r1, r2) => (r1.numerator.toDouble / r1.denominator.toDouble) < (r2.numerator.toDouble / r2.denominator.toDouble)
}

List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted

assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
  List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))