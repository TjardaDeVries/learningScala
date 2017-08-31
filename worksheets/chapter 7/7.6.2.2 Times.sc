



object IntImplicits {
  implicit class ExtraIntMethods(int: Int) {
    def times(f: Int => Unit) = for (i <- 0 until int) yield f(i)
    def yeah = times(_ => println("Oh yeah!"))
  }
}

import IntImplicits._

3.times(i => println(s"Look - it's the number $i!"))

5.yeah
