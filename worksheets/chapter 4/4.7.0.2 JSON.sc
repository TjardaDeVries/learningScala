sealed trait Json {

  def seqHelper(seq: JsSequence): String = seq match {
    case SeqCell(head, SeqEnd) => s"${head.print}"
    case SeqCell(head, tail @ SeqCell(_,_)) => s"${head.print}, ${tail.seqHelper(tail)}"
  }

  def objectHelper(obj: JsObject): String = obj match {
    case ObjectCell(key, value, ObjectEnd) => s"${key}:${value.print}"
    case ObjectCell(key, value, tail @ ObjectCell(_,_,_)) => s"${key}:${value.print}}, ${tail.objectHelper(tail)}"
  }

  def print: String = this match {
    case JsNumber(value) => s"${value}"
    case JsString(value) => s"'${value}'"
    case JsBoolean(value) => s"${value}"
    case JsNull => "JsNull"
    case SeqEnd => "[]"
    case s @ SeqCell(_,_) => "[" + seqHelper(s) + "]"
    case ObjectEnd => "{}"
    case o @ ObjectCell(_,_,_) => "{" + objectHelper(o) + "}"

  }
}

final case class JsNumber(value: Double) extends Json

final case class JsString(value: String) extends Json

final case class JsBoolean(value: Boolean) extends Json

final case object JsNull extends Json

sealed trait JsSequence extends Json

final case class SeqCell(head: Json, tail: JsSequence) extends JsSequence

final case object SeqEnd extends JsSequence

sealed trait JsObject extends Json

final case class ObjectCell(key: String, value: Json, tail: JsObject) extends JsObject

final case object ObjectEnd extends JsObject

SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(JsBoolean(true), SeqEnd))).print

ObjectCell(
  "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber(3.0), SeqEnd))),
  ObjectCell(
    "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell(JsString("c"), SeqEnd))),
    ObjectCell(
      "c", ObjectCell("doh", JsBoolean(true),
        ObjectCell("ray", JsBoolean(false),
          ObjectCell("me", JsNumber(1.0), ObjectEnd))),
      ObjectEnd
    )
  )
).print