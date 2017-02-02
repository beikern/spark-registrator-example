import sbt._

object Version {
  final val Scala     = "2.11.8"
  final val JodaDateTime = "2.8.2"
  final val Spark     = "2.0.2"
  final val ScalaTest = "3.0.0"
  final val KryoSerializers = "0.41"
}

object Library {
  val coreSpark = "org.apache.spark" %% "spark-core" % Version.Spark %"provided"
  val jodaDateTime = "joda-time" % "joda-time" % Version.JodaDateTime
  val scalaTest = "org.scalatest" %% "scalatest" % Version.ScalaTest
  val kryoSerializers = "de.javakaffee" % "kryo-serializers" % Version.KryoSerializers
}
