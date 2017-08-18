

def min(seq: Seq[Int]) = seq.sortWith(_<_).headOption

min(List(7,3,1,6))
min(List())

def smallest(seq: Seq[Int]): Int =
  seq.foldLeft(Int.MaxValue)(math.min)

smallest(List(7,3,1,6))
smallest(List())

def insert(seq: Seq[Int], elt: Int): Seq[Int] = {
  if(seq.contains(elt))
    seq
  else
    elt +: seq
}

def unique(seq: Seq[Int]): Seq[Int] = {
  seq.foldLeft(Seq.empty[Int]){ insert _ }
}

unique(Seq(1, 1, 2, 4, 3, 4))

def reverse(seq: Seq[Int]): Seq[Int] =
  seq.foldLeft(Seq[Int]())((s: Seq[Int], elt: Int) => elt +: s)
// the first arg, Seq[Int]() is called the 'identity element'
reverse(Seq(1, 1, 2, 4, 3, 4))

def myMap[A,B](seq: Seq[A], f: A => B):Seq[B] =
  seq.foldRight(Seq[B]())( (elt: A, s: Seq[B]) => f(elt) +: s)

myMap(Seq[Int](1, 1, 2, 4, 3, 4), (x:Int) => x*2 )


def myFoldLeft[A,B](seq: Seq[A], ie: B, f: (B, A) => B): B = {
  var result: B = ie
  seq.foreach((elt: A) => result = f(result, elt))
  result
}

myFoldLeft(Seq[Int](1, 1, 2, 4, 3, 4), 0, (x:Int,y:Int) => x+y )