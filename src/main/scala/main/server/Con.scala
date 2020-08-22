package server

import java.net._
import java.io._

// handles returning the socket with the connection to 
object Con {
  private val port: Int = 43225
  def getSock: (ServerSocket,Socket) = {
    val ss: ServerSocket = new ServerSocket(port)
    val sock: Socket = ss.accept()
    (ss,sock)
  }
  def closeSock(x: ServerSocket, y: Socket): Unit = { y.close; x.close }
}
