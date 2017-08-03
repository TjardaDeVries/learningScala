final case class Box[A](value: A)

val a = Box[Int](2)
a.value

val b = Box("hi") // if we omit the type parameter, scala will infer its value
b.value

def generic[A](in: A): A = in

generic[String]("foo")
generic(1) // again, if we omit the type parameter, scala will infer it