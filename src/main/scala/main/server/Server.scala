package server

import common._
import scala.concurrent._
import scala.collection.immutable.Queue
import 

object Server {
  
}

// by using an immutable queue, side effects are limited to this object
private object Recv[A] extends Thread {
  private var curQ: Queue[A] = new Queue[A]()

  def getQueue: Queue[A] = curQ

  override def run(): Unit = {
    val sock: Socket = Con.getSock
    recv(sock)
    Con.closeSock(sock)
  }

  // modifies curQ
  def recv[A](skt: Socket): Unit = {
    val inStream: InputStream = skt.getInputStream
    val in: ObjectInputStream = new ObjectInputStream(inStream)
    while(true) {
      val x: A = in.readObject // TODO - does this block until it's read?
      this.curQ = this.curQ.enqueue(x)
    }
  }
}
