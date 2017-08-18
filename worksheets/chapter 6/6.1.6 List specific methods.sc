Nil //empty List
val list = 1 :: 2 :: 3 :: Nil
4 :: 5 :: list
List(1, 2, 3)
List(1, 2, 3) ::: List(4, 5, 6)
// :: and ::: are specific to lists whereas
// +:, :+ and ++ work on any type of sequence.