object IntImplicits {
  implicit class ExtraIntMethods(int: Int) {
    def yeah = for (_ <- 0 until int) yield println("Oh yeah!")
  }
}

import IntImplicits._

2.yeah
3.yeah
-1.yeah