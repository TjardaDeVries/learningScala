import java.util.Date

import persons._
import json._


// class type pattern
trait JsWriter[A] {
  def write(value: A): JsValue
}

// class type instance (implict)
implicit object AnonymousWriter extends JsWriter[Anonymous] {
  def write(value: Anonymous) =
    JsObject(Map("id"         -> JsString(value.id)
               , "createdAt"  -> JsString(value.createdAt.toString)
      ))
}

// class type instance (implict)
implicit object UserWriter extends JsWriter[User] {
  def write(value: User) =
    JsObject(Map("id"         -> JsString(value.id)
               , "email"      -> JsString(value.email)
               , "createdAt"  -> JsString(value.createdAt.toString)
      ))
}

// class type instance (implict)
implicit object VisitorWriter extends JsWriter[Visitor] {
  def write(value: Visitor) = value match {
    case anon: Anonymous => anon.toJson
    case user: User      => user.toJson
  }
}

implicit class JsUtil[A](data: A) {
  def toJson(implicit writer: JsWriter[A]) =
    writer.write(data)
}

val user1 = new User("tjarda", "tjarda@ordina.nl")
user1.toJson.stringify

val visitors: Seq[Visitor] = Seq(Anonymous("001", new Date), User("003", "dave@xample.com", new Date))

for {
  visitor <- visitors
} yield visitor.toJson.stringify







