organization := "com.titus"

name := "scala-chat-server"

version := "pre-release"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  // https://mvnrepository.com/artifact/org.scalatest/scalatest - scalatest
  "org.scalatest" %% "scalatest" % "3.2.2" % Test,
  // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.9"
)

