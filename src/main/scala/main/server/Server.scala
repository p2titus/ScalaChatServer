package server

import common._
import scala.collection.immutable.Queue

import java.net.Socket
import java.net.ServerSocket

import akka.actor._

/*object Server { // encapsulates the recv class into a single concrete instance
  private val recv: Recv[Message] = new Recv

  def startServer: Unit = recv.run()
  def endServer: Unit = recv.endServer
  def getQ: Queue[Message] = recv.getQueue
}*/

// by using an immutable queue, side effects are limited to this object
// surely there must be a better way to do this involving asynch
/*private class Recv[A] extends Thread {
  private var curQ: Queue[A] = Queue.empty[A]
  private var fin: Boolean = false

  def getQueue: Queue[A] = curQ

  def endServer: Unit = fin = true

  override def run(): Unit = {
    fin = false
    val con: Con.type = Con
    val ss: ServerSocket = con.getServerSock
    
    while(!fin) {
      val sock: Socket = con.getSock(ss)
      recv(sock)
      Con.close(sock)
    }

    Con.close(ss)
  }

  // modifies curQ
  private def recv(skt: Socket): Unit = {
    val inStream: InputStream = skt.getInputStream
    val in: ObjectInputStream = new ObjectInputStream(inStream)
    println("Just before")
    val x: A = in.readObject.asInstanceOf[A] // TODO - does this block until it's read?
    println("GOT SOMETHING!")
    this.curQ = this.curQ.enqueue(x)
  }
}*/

class Recv[A] extends Actor {
  private var fin: Boolean = false
  
  override def receive = {
    case msg: Boolean => { fin = msg; if(msg) startListen }
  }

  def startListen: Unit = {
    val con: Con.type = Con
    val ss: ServerSocket = con.getServerSock

    while(!fin) {
      con.getSock(ss)
    }
    Con.close(ss)
  }

  private def listen: Unit = {
    
  }
}

private class Send[A] extends Actor {
  val msg: String = "not ready yet"

  override def receive = {
    case msg: Message => sendMsg(msg)
  }

  private def sendMsg(msg: Message): Unit = {
    
  }
}
