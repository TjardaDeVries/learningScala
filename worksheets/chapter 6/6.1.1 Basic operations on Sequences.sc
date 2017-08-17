val sequence = Seq(1, 2, 3)
val test: Seq[Int] = Seq()

// Accessing elements:

sequence.apply(0)
sequence(0) // sugared syntax

sequence.head
sequence.tail
sequence.tail.head
// Seq().head => error
sequence.headOption
Seq().headOption
test.headOption

// Length
sequence.length

// Searching for elements
sequence.contains(2)
sequence.find(_ == 3)
sequence.find(_ > 4)
sequence.filter(_ > 1)

// Sorting elements
sequence.sortWith(_ > _)

// Appending/prepending elements
sequence.:+(4)
sequence :+ 4
sequence.+:(0)
5 +: 0 +: sequence
sequence ++ Seq(4, 5, 6)


