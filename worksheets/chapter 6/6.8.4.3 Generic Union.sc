
def union[A,B](map1: Map[A, B], map2: Map[A, B], add: (B, B) => B): Map[A, B] = {
  map1.foldLeft(map2) { (map, tuple) =>
    val (k, v) = tuple
    val newV = if (map.contains(k)) {
      add(map(k),v)
    } else {
      map(k)
    }
    map + (k -> newV)
  }
}
val map1 = Map('a' -> 1, 'b' -> 2)
val map2 = Map('a' -> 2, 'b' -> 4)

union[Char,Int](map1, map2, (v1,v2) => v1 + v2)