def union[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A, Int] = {
  map1.foldLeft(map2) { (map, tuple) =>
    val (k, v) = tuple
    val newV = if (map.contains(k)) {
      map(k) + v
    } else {
      map(k)
    }
    map + (k -> newV)
  }
}


val map1 = Map('a' -> 1, 'b' -> 2)
val map2 = Map('a' -> 2, 'b' -> 4)

union(map1, map2)