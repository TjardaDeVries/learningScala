final case class Distribution[A](events: List[(A, Double)]) {

//  def map[B](f: A => B): Distribution[B] =
//    Distribution[B](for {
//      (a, d) <- this.events
//    } yield f(a) -> d)

  def map[B](f: A => B): Distribution[B] =
    Distribution[B](events map {case (a,d) => f(a) -> d})

  // This implementation is somewhat correct...
  // See book for proper implementation!
  def flatMap[B](f: A => Distribution[B]): Distribution[B] =
    Distribution[B](    for {
      dist <- events map { case (a, d) => f(a) }
      event <- dist.events
    } yield event)

}

object Distribution {
  def uniform[A](atoms: List[A]): Distribution[A] = {
    val p = 1.0 / atoms.length
    Distribution(atoms.map(a => a -> p))
  }
}





