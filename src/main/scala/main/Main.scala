// starts the main loop

import server._
import common._
import akka.actor._

object Main {
  def main(args: Array[String]): Unit = {
    println("Starting server")
    
    val as = ActorSystem("ActorSystem")
    val listener = as.actorOf(Props[Recv[Message]],"Receiver")
    listener ! true
  }
}
