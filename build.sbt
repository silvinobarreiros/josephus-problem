import Dependencies._

//import sbtdocker._

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "org.silvino",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "stash-user-service",
    libraryDependencies ++= dependencies
  )

lazy val dependencies = Seq(
  "org.mockito"          % "mockito-core"           % "2.8.47" % Test,
  scalaTest % Test
)

mainClass in (Compile, run) := Some("silvino.Main")
