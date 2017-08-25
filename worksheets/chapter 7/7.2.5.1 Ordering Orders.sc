final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object OrderOrderingByTotalPrice {
  implicit val ordering = Ordering.fromLessThan[Order](_.totalPrice < _.totalPrice)
}

object OrderOrderingByUnits {
  implicit val ordering = Ordering.fromLessThan[Order](_.units < _.units)
}

object OrderOrderingByUnitPrice {
  implicit val ordering = Ordering.fromLessThan[Order](_.unitPrice < _.unitPrice)
}