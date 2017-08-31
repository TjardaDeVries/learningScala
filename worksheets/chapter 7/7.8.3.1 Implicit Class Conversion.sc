object IntImplicits {
  class IntOps(int: Int) {
    def yeah = for (_ <- 0 until int) yield println("Oh yeah!")
  }
  implicit def intToIntOps(int: Int) = new IntOps(int)
}

import IntImplicits._

2.yeah
3.yeah
-1.yeah