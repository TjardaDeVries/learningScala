package counting

/**
 * Created by Tjarda on 14/07/2017.
 */
case class Counter(count: Int = 0) {
  def dec = copy(count = count - 1)
  def inc = copy(count = count + 1)
  def adjust(adder: Adder) = copy(count = adder.add(count))
}
