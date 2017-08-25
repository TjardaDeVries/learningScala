implicit val ordering = Ordering.fromLessThan[Int](_ < _)

List(2, 4, 3).sorted
List(1, 7 ,5).sorted