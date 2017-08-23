val set1 = Set(3, 5, 7, 2)
val set2 = Set(4, 5, 7, 2)

def union[A](set1: Set[A], set2: Set[A]): Set[A] = {

  set1.foldLeft(set2)((result, element) =>
    if (result.contains(element))
      result
    else
      result + element)
}

def union2[A](set1: Set[A], set2: Set[A]): Set[A] = {
  set1.foldLeft(set2){ (set, elt) => (set + elt) }
}

union(set1, set2)
union2(set1, set2)