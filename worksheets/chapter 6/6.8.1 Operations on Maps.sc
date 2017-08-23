//IMMUTABLE MAPs

val example = Map("a" -> 1, "b" -> 2, "c" -> 3)

//Accessing values using keys
"a" -> 1 // -> is contructor for Tuple2
example("a")
example.get("a")
//example("d")
example.get("d")
example.getOrElse("d", -1)

//Determining membership
example.contains("a")

//Determining size
example.size

//Adding and removing elements
example.+("c" -> 10, "d" -> 11, "e" -> 12)
example.-("b", "c")
example + ("d" -> 4) - "c"

//MUTABLE MAPs

val example2 = scala.collection.mutable.Map("x" -> 10, "y" -> 11, "z" -> 12)

example2 += ("x" -> 20)
example2 -= ("y", "z")
example2
example2.update("w", 30)
example2

//Sorted maps

Map("a" -> 1) + ("b" -> 2) + ("c" -> 3) + ("d" -> 4) + ("e" -> 5)
scala.collection.immutable.ListMap("a" -> 1) + ("b" -> 2) + ("c" -> 3) + ("d" -> 4) + ("e" -> 5)

//map and flatMap

example.map(pair => pair._1 -> pair._2 * 2)
example.map(pair => pair._1 + " = " + pair._2)
example.flatMap {
  case (str, num) =>
    (1 to 3).map(x => (str + x) -> (num * x))
}

for {
  (str, num) <- example
  x <- 1 to 3
} yield (str + x) -> (num * x)

for {
  (str, num) <- example
  x <- 1 to 3
} yield (x + str) + "=" + (x * num)

