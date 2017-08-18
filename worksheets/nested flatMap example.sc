//val chars = 'a' to 'z'

val chars = List('a', 'b', 'c')

val perms = chars flatMap { a =>
  chars flatMap { b =>
    if (a != b) Seq("%c%c".format(a, b))
    else Seq()
  }
}


val data = Seq(Seq(1), Seq(2, 3), Seq(4, 5, 6))
data.flatMap(_.map(_ * 2))