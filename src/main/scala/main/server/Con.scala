package server

import java.net._
import java.io._

// handles returning the socket with the connection to 
object Con {
  private val ip: String = "127.0.0.1"
  private val port: Int = 43225
  def getSock: Socket = new Socket(ip,port)
  def closeSock(x: Socket): Unit = x.close
}
