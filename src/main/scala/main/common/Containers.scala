// file for data structures that are common between all parts of the program
package common

case class User(val userID: Int, val username: String, val password: Option[String])
case class Message(val msg: String, val metadata: Metadata)
case class Metadata(val sender: User, val receiver: User) {
  def respond: Metadata = Metadata(receiver,sender)
}
