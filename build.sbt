lazy val `spark-examples` =
  project.in(file("."))
    .settings(
    mainClass in assembly := Some("es.beikern.spark.examples.Main"),
    assemblyJarName in assembly := "sparkfail.jar"
    )
    .enablePlugins(AutomateHeaderPlugin, GitVersioning)

libraryDependencies ++= Vector(
  Library.coreSpark,
  Library.jodaDateTime,
  Library.kryoSerializers,
  Library.scalaTest % "test"
)

initialCommands := """|import es.beikern.spark.examples._
                      |""".stripMargin
