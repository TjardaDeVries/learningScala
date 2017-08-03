sealed trait Json
final case class JsNumber(value:Double) extends Json
final case class JsString(value:String) extends Json
final case class JsBoolean(value:Boolean) extends Json
final case object JsNull extends Json
case class JsSequence extends Json
case class JsObject extends Json

sealed trait JsSequence
final case class SeqCell() extends JsSequence
final case object SeqEnd extends JsSequence