package server

import common._
import scala.concurrent._
import scala.collection.immutable.Queue

object Server {
  
}

// by using an immutable queue, side effects are limited to this object
private object Recv[A] extends Thread {
  private var curQ: Queue[A] = new Queue[A]()
  def getQueue: Queue[A] = curQ

  override def run(): Unit = recv

  def recv: Unit = {
    while(true) {

    }
  }
}
