
val list = List(1, 2, 3)

list.flatMap((x: Int) => List(x, -x))


val list2 = List(Full(3), Full(2), Full(1))

list2.map((x: Maybe[Int]) => if (Full(x) % 2 == 0) x else Empty)