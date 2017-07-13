class Counter(val count: Int) {
  def dec: Counter = dec()
  def inc: Counter = inc()
  def inc(amount: Int = 1): Counter =
    new Counter(this.count + amount)
  def dec(amount: Int = 1): Counter =
    new Counter(this.count - amount)
  def adjust(adder: Adder): Counter =
    new Counter(adder.add(this.count))
}

//Adders are both objects and computations.
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}


// =================================
new Counter(10).inc.dec.inc.inc.count
new Counter(10).inc.inc(10).count
new Adder(10).add(2)
val temp = new Adder(10)
temp.add(0)


//apply method
class Adder2(amount: Int) {
  def apply(in: Int): Int = in + amount
}

val add3 = new Adder2(3)
add3(2)


