lazy val `spark-examples` =
  project.in(file(".")).enablePlugins(AutomateHeaderPlugin, GitVersioning)

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import es.beikern.spark.examples._
                      |""".stripMargin
