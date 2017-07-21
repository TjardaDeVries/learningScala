sealed trait Source
final case object Well extends Source
final case object Spring extends Source
final case object Tap extends Source

case class BottledWater(size: Int, source: Source, carbonated: Boolean)