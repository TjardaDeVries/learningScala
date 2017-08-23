//Filtering

for {
  x <- Seq(-2, -1, 0, 1, 2) if x > 0
} yield x


//Parallel Iteration
for {
  x <- Seq(1, 2, 3)
  y <- Seq(4, 5, 6)
} yield x + y

Seq(1, 2, 3).zip(Seq(4, 5, 6))
for {
  x <- Seq(1, 2, 3).zip(Seq(4, 5, 6))
} yield {
  val (a, b) = x
  a + b
}

for {
  x <- Seq(1, 2, 3).zipWithIndex
} yield x

//Pattern Matching
for {
  (a,b) <- Seq(1, 2, 3).zip(Seq(4, 5, 6))
} yield {
  a + b
}

//Intermediate Results
for {
  x     <- Seq(1, 2, 3)
  square = x * x
  y     <- Seq(4, 5, 6)
} yield square * y