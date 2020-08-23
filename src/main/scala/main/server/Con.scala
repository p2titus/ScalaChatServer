package server

import java.net._
import java.io._

// handles returning the socket with the connection to 
object Con {
  private val port: Int = 43225
  def getSock(ss: ServerSocket): Socket = ss.accept

  def getServerSock: ServerSocket = new ServerSocket(port)

  def close[A <% Closeable](x: A): Unit = x.close
}
